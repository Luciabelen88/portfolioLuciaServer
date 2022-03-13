package com.portfolioLucia.PortfolioLucia.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "hardsoftskills")
public class HardSoftSkills {
    @Getter
    @Setter
    @Id
    @Column(name = "skills_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long skills_id;
    @Getter
    @Setter
    @Column(name = "title")
    private String title;
    @Getter
    @Setter
    @Column(name = "description")
    private String description;
    @Getter
    @Setter
    @Column(name = "skill_level")
    private String skill_level;
    @Getter
    @Setter
    @Column(name = "author")
    private String author;

}
