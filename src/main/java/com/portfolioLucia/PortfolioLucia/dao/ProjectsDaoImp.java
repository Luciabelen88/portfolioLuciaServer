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
}
