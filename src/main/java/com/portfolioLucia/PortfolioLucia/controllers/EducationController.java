package com.portfolioLucia.PortfolioLucia.controllers;

import com.portfolioLucia.PortfolioLucia.dao.EducationDao;
import com.portfolioLucia.PortfolioLucia.models.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class EducationController {
    @Autowired
    private EducationDao educationDao;

    @CrossOrigin(origins = "https://portfoliolucia-fa171.web.app")
    @RequestMapping(value= "education", method = RequestMethod.GET)
    public List<Education> getEducation() {
        return educationDao.getEducation();

    }
    @CrossOrigin(origins = "https://portfoliolucia-fa171.web.app")
    @RequestMapping(value= "education/{id}", method = RequestMethod.DELETE)
    public void deleteEducation(@PathVariable Long id) {
        educationDao.deleteEducation(id);

    }

    @CrossOrigin(origins = "https://portfoliolucia-fa171.web.app")
    @RequestMapping(value= "education", method = RequestMethod.POST)
    public Long addEducation(@RequestBody Education education) {
        return educationDao.addEducation(education);

    }

    @CrossOrigin(origins = "https://portfoliolucia-fa171.web.app")
    @RequestMapping(value="education", method = RequestMethod.PUT)
    public Long updateEducation(@RequestBody Education education) {
        return educationDao.updateEducation(education);
    }




}
