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

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value= "education", method = RequestMethod.GET)
    public List<Education> getEducation() {
        return educationDao.getEducation();

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value= "education/{education_id}", method = RequestMethod.DELETE)
    public void deleteEducation(@PathVariable Long education_id) {
        educationDao.deleteEducation(education_id);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value= "education", method = RequestMethod.POST)
    public void addEducation(@RequestBody Education education) {
        educationDao.addEducation(education);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="education", method = RequestMethod.PUT)
    public Education updateEducation(@RequestBody Education education) {
        return educationDao.updateEducation(education);
    }




}