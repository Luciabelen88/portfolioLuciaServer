package com.portfolioLucia.PortfolioLucia.dao;

import com.portfolioLucia.PortfolioLucia.models.Projects;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
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
    public Projects getById(Long id) {
        Iterator<Projects> iterator = getProjects().iterator();
        while (iterator.hasNext()) {
            Projects project = iterator.next();
            if (project.getProject_id().equals(id)) {
                return project;
            }
        }
        return null;
    }

    @Override
    public void deleteProject(Long id) {
        Projects projects = entityManager.find(Projects.class, id);
        entityManager.remove(projects);
    }

    @Override
    public Long addProject(Projects projects) {
        Projects managedEntity = entityManager.merge(projects);
        return managedEntity.getProject_id();
    }

    @Override
    public Long updateProject(Projects projects) {
        Projects projectToModify = entityManager.find(Projects.class, projects.getProject_id());
        entityManager.detach(projectToModify);
        projectToModify = projects;
        entityManager.merge(projectToModify);
        return projectToModify.getProject_id();
    }

}
