package com.portfolioLucia.PortfolioLucia.dao;

import com.portfolioLucia.PortfolioLucia.models.Experience;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ExperienceDaoImp implements ExperienceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Experience> getExperience() {
        String query = "FROM Experience";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deleteExperience(Long experience_id) {
        Experience experience = entityManager.find(Experience.class, experience_id);
        entityManager.remove(experience);
    }

    @Override
    public void addExperience(Experience experience) {
        entityManager.merge(experience);
    }

    @Override
    public Experience updateExperience(Experience experience) {
        Experience experienceToModify = entityManager.find(Experience.class, experience.getExperience_id());
        entityManager.detach(experienceToModify);
        experienceToModify = experience;
        return entityManager.merge(experienceToModify);

    }
}
