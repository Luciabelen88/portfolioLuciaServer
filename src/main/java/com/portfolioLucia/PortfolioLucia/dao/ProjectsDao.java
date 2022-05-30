package com.portfolioLucia.PortfolioLucia.dao;

import com.portfolioLucia.PortfolioLucia.models.Projects;

import java.util.List;

public interface ProjectsDao {
    List<Projects> getProjects();

    Projects getById(Long id);

    void deleteProject(Long id);

    Long addProject(Projects projects);

    Projects updateProject(Projects projects);
}

