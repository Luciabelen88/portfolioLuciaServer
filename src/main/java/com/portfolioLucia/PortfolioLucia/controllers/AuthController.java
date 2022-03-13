package com.portfolioLucia.PortfolioLucia.controllers;

import com.portfolioLucia.PortfolioLucia.dao.AuthorDao;
import com.portfolioLucia.PortfolioLucia.models.Author;
import com.portfolioLucia.PortfolioLucia.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthController {
    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private JWTUtil jwtUtil;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestBody Author author) {
        Author authorLoggedin= authorDao.getAuthorByCredentials(author);
        if (authorLoggedin != null) {
            String token = jwtUtil.create(authorLoggedin.getUser_name(), authorLoggedin.getEmail());
            return token;
        } else{
            return null;
        }

    }

}
