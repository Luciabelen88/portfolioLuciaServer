package com.portfolioLucia.PortfolioLucia.controllers;

import com.portfolioLucia.PortfolioLucia.dao.ProjectsDao;
import com.portfolioLucia.PortfolioLucia.models.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value= "projects/{project_id}", method = RequestMethod.DELETE)
    public void deleteProject(@PathVariable Long project_id) {
        projectsDao.deleteProject(project_id);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value= "projects", method = RequestMethod.POST)
    public void addProject(@RequestBody Projects projects) {
        projectsDao.addProject(projects);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="projects", method = RequestMethod.PUT)
    public Long updateProject(@RequestBody Projects projects) {
        return projectsDao.updateProject(projects);
    }
}
