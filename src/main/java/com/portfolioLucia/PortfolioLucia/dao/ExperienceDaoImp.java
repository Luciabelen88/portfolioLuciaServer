package com.portfolioLucia.PortfolioLucia.dao;

import com.portfolioLucia.PortfolioLucia.models.Experience;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
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
    public Experience getById(Long id) {
        Iterator<Experience> iterator = getExperience().iterator();
        while (iterator.hasNext()) {
            Experience experience = iterator.next();
            if (experience.getExperience_id().equals(id)) {
                return experience;
            }
        }
        return null;
    }

    @Override
    public void deleteExperience(Long id) {
        Experience experience = entityManager.find(Experience.class, id);
        entityManager.remove(experience);
    }

    @Override
    public Long addExperience(Experience experience) {
       Experience managedEntity = entityManager.merge(experience);
       return managedEntity.getExperience_id();
    }

    @Override
    public Experience updateExperience(Experience experience) {
        Experience experienceToModify = entityManager.find(Experience.class, experience.getExperience_id());
        entityManager.detach(experienceToModify);
        experienceToModify = experience;
        return entityManager.merge(experienceToModify);

    }
}
