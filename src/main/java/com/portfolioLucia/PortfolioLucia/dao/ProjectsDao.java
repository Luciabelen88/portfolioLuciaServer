package com.portfolioLucia.PortfolioLucia.dao;

import com.portfolioLucia.PortfolioLucia.models.Projects;

import java.util.List;

public interface ProjectsDao {
    List<Projects> getProjects();

    void deleteProject(Long project_id);

    void addProject(Projects projects);

    Projects updateProject(Projects projects);
}
