package com.portfolioLucia.PortfolioLucia.controllers;

import com.portfolioLucia.PortfolioLucia.dao.ProjectsDao;
import com.portfolioLucia.PortfolioLucia.models.Education;
import com.portfolioLucia.PortfolioLucia.models.Experience;
import com.portfolioLucia.PortfolioLucia.models.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectsController {
    @Autowired
    private ProjectsDao projectsDao;
    @CrossOrigin(origins = "https://portfoliolucia-fa171.web.app")
    @RequestMapping(value = "projects", method = RequestMethod.GET)
    public List<Projects> getProjects() {
        return projectsDao.getProjects();
    }

    @CrossOrigin(origins = "https://portfoliolucia-fa171.web.app")
    @RequestMapping(value= "projects/{id}", method = RequestMethod.DELETE)
    public void deleteProject(@PathVariable Long id) {
        projectsDao.deleteProject(id);

    }

    @CrossOrigin(origins = "https://portfoliolucia-fa171.web.app")
    @RequestMapping(value= "projects", method = RequestMethod.POST)
    public Long addProject(@RequestBody Projects projects) {
        return projectsDao.addProject(projects);

    }

    @CrossOrigin(origins = "https://portfoliolucia-fa171.web.app")
    @RequestMapping(value="projects", method = RequestMethod.PUT)
    public Projects updateProject(@RequestBody Projects projects) {

        return projectsDao.updateProject(projects);
    }

}
