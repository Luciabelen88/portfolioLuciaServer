package com.portfolioLucia.PortfolioLucia.security;

import com.portfolioLucia.PortfolioLucia.dao.AuthorDaoImp;
import com.portfolioLucia.PortfolioLucia.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;


public class CustomAuthenticationManager implements AuthenticationManager {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorDaoImp authorDaoImp;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

         Author author = authorDaoImp.getAuthor().get(0);

        if (!passwordEncoder.matches(password, author.getPassword())) {
            throw new BadCredentialsException("Bad Credentials");
        }

        return new UsernamePasswordAuthenticationToken(username, password);
    }
}
