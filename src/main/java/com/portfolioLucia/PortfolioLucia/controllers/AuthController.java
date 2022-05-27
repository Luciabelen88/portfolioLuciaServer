package com.portfolioLucia.PortfolioLucia.controllers;


import com.portfolioLucia.PortfolioLucia.models.AuthenticationRequest;
import com.portfolioLucia.PortfolioLucia.models.AuthenticationResponse;
import com.portfolioLucia.PortfolioLucia.security.CustomAuthenticationManager;
import com.portfolioLucia.PortfolioLucia.service.MyUserDetailsService;
import com.portfolioLucia.PortfolioLucia.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@RestController
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomAuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final User userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }


}
