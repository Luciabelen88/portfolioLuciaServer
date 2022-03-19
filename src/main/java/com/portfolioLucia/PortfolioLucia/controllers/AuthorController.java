package com.portfolioLucia.PortfolioLucia.controllers;

import com.portfolioLucia.PortfolioLucia.dao.AuthorDao;
import com.portfolioLucia.PortfolioLucia.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value= "author/{user_name}", method = RequestMethod.DELETE)
    public void deleteAuthor(@PathVariable Long user_name) {
        authorDao.deleteAuthor(user_name);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value= "author", method = RequestMethod.POST)
    public void addAuthor(@RequestBody Author author) {
        authorDao.addAuthor(author);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="author", method = RequestMethod.PUT)
    public Author updateAuthor(@RequestBody Author author) {
        return authorDao.updateAuthor(author);
    }
}
