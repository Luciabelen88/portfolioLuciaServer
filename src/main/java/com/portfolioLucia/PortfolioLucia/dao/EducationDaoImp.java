package com.portfolioLucia.PortfolioLucia.dao;

import com.portfolioLucia.PortfolioLucia.models.Education;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;

@Repository
@Transactional
public class EducationDaoImp implements EducationDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Education> getEducation() {
        String query = "FROM Education";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Education getById(Long id) {
        Iterator<Education> iterator = getEducation().iterator();
        while (iterator.hasNext()) {
            Education education = iterator.next();
            if (education.getEducation_id().equals(id)) {
                return education;
            }
        }
        return null;
    }

    @Override
    public void deleteEducation(Long id) {
        Education education = entityManager.find(Education.class, id);
        entityManager.remove(education);
    }

    @Override
    public Long addEducation(Education education) {
        Education managedEntity = entityManager.merge(education);
        return managedEntity.getEducation_id();
    }

    @Override
    public Long updateEducation(Education education) {
        Education educationToModify = entityManager.find(Education.class, education.getEducation_id());
        entityManager.detach(educationToModify);
        educationToModify = education;
        entityManager.merge(educationToModify);
        return  educationToModify.getEducation_id();

    }

}
