package com.portfolioLucia.PortfolioLucia.controllers;

import com.portfolioLucia.PortfolioLucia.dao.HardSoftSkillsDao;
import com.portfolioLucia.PortfolioLucia.models.HardSoftSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HardSoftSkillsController {

    @Autowired
    private HardSoftSkillsDao hardSoftSkillsDao;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "hardsoftskills", method = RequestMethod.GET)
    public List<HardSoftSkills> getHardSoftSkills() {

        return hardSoftSkillsDao.getHardSoftSkills();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "hardsoftskills/{skills_id}", method = RequestMethod.DELETE)
    public void getHardSoftSkills(@PathVariable Long skills_id) {

        hardSoftSkillsDao.deleteHardSoftSkills(skills_id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "hardsoftskills", method = RequestMethod.POST)
    public void addHardSoftSkills(@RequestBody HardSoftSkills hardSoftSkills) {
        hardSoftSkillsDao.addHardSoftSkills(hardSoftSkills);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "hardsoftskills", method = RequestMethod.PUT)
    public HardSoftSkills updateHardSoftSkills(@RequestBody HardSoftSkills hardSoftSkills) {
        return hardSoftSkillsDao.updateHardSoftSkills(hardSoftSkills);
    }

}
