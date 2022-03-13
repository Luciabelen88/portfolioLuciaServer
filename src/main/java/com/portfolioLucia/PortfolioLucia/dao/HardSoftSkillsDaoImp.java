package com.portfolioLucia.PortfolioLucia.dao;

import com.portfolioLucia.PortfolioLucia.models.HardSoftSkills;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class HardSoftSkillsDaoImp implements HardSoftSkillsDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<HardSoftSkills> getHardSoftSkills() {
        String query = "FROM HardSoftSkills";
        return entityManager.createQuery(query).getResultList();
    }


    @Override
    public void deleteHardSoftSkills(Long skills_id) {
        HardSoftSkills hardSoftSkills = entityManager.find(HardSoftSkills.class, skills_id);
        entityManager.remove(hardSoftSkills);
    }

    @Override
    public void addHardSoftSkills(HardSoftSkills hardSoftSkills) {

        entityManager.merge(hardSoftSkills);
    }

    @Override
    public HardSoftSkills updateHardSoftSkills(HardSoftSkills hardSoftSkills) {
        HardSoftSkills hardSoftSkillsToModify = entityManager.find(HardSoftSkills.class, hardSoftSkills.getSkills_id());
        entityManager.detach(hardSoftSkillsToModify);
        hardSoftSkillsToModify = hardSoftSkills;
        return entityManager.merge(hardSoftSkillsToModify);

    }
}
