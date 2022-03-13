package com.portfolioLucia.PortfolioLucia.controllers;

import com.portfolioLucia.PortfolioLucia.dao.SkillsLevelDao;
import com.portfolioLucia.PortfolioLucia.models.SkillsLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkillsLevelController {
    @Autowired
    private SkillsLevelDao skillsLevelDao;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "skillslevel")
    public List<SkillsLevel> getSkillsLevel() {
        return skillsLevelDao.getSkillsLevel();
    }
}
