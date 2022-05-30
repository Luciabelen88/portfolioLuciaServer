package com.portfolioLucia.PortfolioLucia.dao;
import com.portfolioLucia.PortfolioLucia.models.Experience;

import java.util.List;
public interface ExperienceDao {
    List<Experience> getExperience();

    void deleteExperience(Long id);

    Experience getById(Long id);

    Long addExperience(Experience experience);

    Experience updateExperience(Experience experience);
}
