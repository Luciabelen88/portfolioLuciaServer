package com.portfolioLucia.PortfolioLucia.dao;

import com.portfolioLucia.PortfolioLucia.models.Projects;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProjectsDaoImp implements ProjectsDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Projects> getProjects() {
        String query = "FROM Projects";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deleteProject(Long project_id) {
        Projects projects = entityManager.find(Projects.class, project_id);
        entityManager.remove(projects);
    }

    @Override
    public void addProject(Projects projects) {
        entityManager.merge(projects);
    }

    @Override
    public Projects updateProject(Projects projects) {
        Projects projectToModify = entityManager.find(Projects.class, projects.getProject_id());
        entityManager.detach(projectToModify);
        projectToModify = projects;
        return entityManager.merge(projectToModify);
    }
}
