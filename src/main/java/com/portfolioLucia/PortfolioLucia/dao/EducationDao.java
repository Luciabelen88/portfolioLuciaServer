package com.portfolioLucia.PortfolioLucia.dao;

import com.portfolioLucia.PortfolioLucia.models.Education;

import java.util.List;

public interface EducationDao {
    List<Education> getEducation();

    void deleteEducation(Long id);

    Education getById(Long id);

    Long addEducation(Education education);

    Long updateEducation(Education education);


}
