package com.portfolioLucia.PortfolioLucia.dao;

import com.portfolioLucia.PortfolioLucia.models.Education;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public void deleteEducation(Long education_id) {
        Education education = entityManager.find(Education.class, education_id);
        entityManager.remove(education);
    }

    @Override
    public void addEducation(Education education) {
        entityManager.merge(education);
    }

    @Override
    public Education updateEducation(Education education) {
        Education educationToModify = entityManager.find(Education.class, education.getEducation_id());
        entityManager.detach(educationToModify);
        educationToModify = education;
        return entityManager.merge(educationToModify);

    }

}
