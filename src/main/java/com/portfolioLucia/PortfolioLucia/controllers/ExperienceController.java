package com.portfolioLucia.PortfolioLucia.controllers;

import com.portfolioLucia.PortfolioLucia.dao.ExperienceDao;
import com.portfolioLucia.PortfolioLucia.models.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value= "experience/{experience_id}", method = RequestMethod.DELETE)
    public void deleteExperience(@PathVariable Long experience_id) {
        experienceDao.deleteExperience(experience_id);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value= "experience", method = RequestMethod.POST)
    public void addExperience(@RequestBody Experience experience) {
        experienceDao.addExperience(experience);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="experience", method = RequestMethod.PUT)
    public Experience updateExperience(@RequestBody Experience experience) {
        return experienceDao.updateExperience(experience);
    }
}
