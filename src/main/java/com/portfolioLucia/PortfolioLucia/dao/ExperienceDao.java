package com.portfolioLucia.PortfolioLucia.dao;
import com.portfolioLucia.PortfolioLucia.models.Experience;

import java.util.List;
public interface ExperienceDao {
    List<Experience> getExperience();

    void deleteExperience(Long experience_id);

    void addExperience(Experience experience);

    Experience updateExperience(Experience experience);
}
