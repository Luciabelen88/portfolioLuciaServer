package com.portfolioLucia.PortfolioLucia.controllers;

import com.portfolioLucia.PortfolioLucia.dao.ExperienceDao;
import com.portfolioLucia.PortfolioLucia.models.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExperienceController {
    @Autowired
    private ExperienceDao experienceDao;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "experience")
    public List<Experience> getExperience() {
        return experienceDao.getExperience();

    }
}
