package com.portfolioLucia.PortfolioLucia.controllers;

import com.portfolioLucia.PortfolioLucia.dao.ProjectsDao;
import com.portfolioLucia.PortfolioLucia.models.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectsController {
    @Autowired
    private ProjectsDao projectsDao;
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "projects")
    public List<Projects> getProjects() {
        return projectsDao.getProjects();
    }
}
