package com.portfolioLucia.PortfolioLucia.dao;

import com.portfolioLucia.PortfolioLucia.models.HardSoftSkills;

import java.util.List;

public interface HardSoftSkillsDao {
    List<HardSoftSkills> getHardSoftSkills();

    void deleteHardSoftSkills(Long skills_id);

    void addHardSoftSkills(HardSoftSkills hardSoftSkills);

    HardSoftSkills updateHardSoftSkills(HardSoftSkills hardSoftSkills);
}
