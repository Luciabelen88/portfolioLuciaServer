package com.portfolioLucia.PortfolioLucia.controllers;

import com.portfolioLucia.PortfolioLucia.dao.AuthorDao;
import com.portfolioLucia.PortfolioLucia.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorDao authorDao;

    @Autowired
    EntityManager entityManager;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="author", method = RequestMethod.GET)
    public List<Author> getAuthor() {
        List<Author> authorProfile = new ArrayList<>();
        authorProfile.addAll(authorDao.getAuthor());
        authorProfile.get(0).setPassword("");
        return authorProfile;
    }

    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="setEncodedPassword", method = RequestMethod.PATCH)
    public void setEncodedPassword(@RequestBody String password){
        authorDao.setEncodedPassword(password);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="author", method = RequestMethod.PUT)
    public void updateAuthor(@RequestBody Author author) {
        author.setPassword(authorDao.getAuthor().get(0).getPassword());
        authorDao.updateAuthor(author);
    }



}
