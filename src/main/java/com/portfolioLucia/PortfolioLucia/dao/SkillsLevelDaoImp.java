package com.portfolioLucia.PortfolioLucia.dao;

import com.portfolioLucia.PortfolioLucia.models.SkillsLevel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class SkillsLevelDaoImp implements SkillsLevelDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SkillsLevel> getSkillsLevel() {
        String query = "FROM SkillsLevel";
        return entityManager.createQuery(query).getResultList();
    }
}
