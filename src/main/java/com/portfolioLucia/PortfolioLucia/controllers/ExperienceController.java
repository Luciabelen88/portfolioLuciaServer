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

    @CrossOrigin(origins = "https://portfoliolucia-fa171.web.app")
    @RequestMapping(value = "experience")
    public List<Experience> getExperience() {
        return experienceDao.getExperience();

    }

    @CrossOrigin(origins = "https://portfoliolucia-fa171.web.app")
    @RequestMapping(value= "experience/{id}", method = RequestMethod.DELETE)
    public void deleteExperience(@PathVariable Long id) {
        experienceDao.deleteExperience(id);

    }

    @CrossOrigin(origins = "https://portfoliolucia-fa171.web.app")
    @RequestMapping(value= "experience", method = RequestMethod.POST)
    public  Long addExperience(@RequestBody Experience experience) {
        return experienceDao.addExperience(experience);

    }

    @CrossOrigin(origins = "https://portfoliolucia-fa171.web.app")
    @RequestMapping(value="experience", method = RequestMethod.PUT)
    public Experience updateExperience(@RequestBody Experience experience) {
        return experienceDao.updateExperience(experience);
    }
}
