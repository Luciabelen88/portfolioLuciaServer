package com.portfolioLucia.PortfolioLucia.dao;

import com.portfolioLucia.PortfolioLucia.models.Education;

import java.util.List;

public interface EducationDao {
    List<Education> getEducation();

    void deleteEducation(Long education_id);

    void addEducation(Education education);

    Education updateEducation(Education education);
}
