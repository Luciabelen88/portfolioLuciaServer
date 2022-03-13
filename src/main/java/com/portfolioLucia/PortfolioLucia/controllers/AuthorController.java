package com.portfolioLucia.PortfolioLucia.controllers;

import com.portfolioLucia.PortfolioLucia.dao.AuthorDao;
import com.portfolioLucia.PortfolioLucia.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorDao authorDao;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "author")
    public List<Author> getAuthor() {
        return authorDao.getAuthor();

    }
}
