package com.portfolioLucia.PortfolioLucia.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "skillslevel")
public class SkillsLevel {
    @Getter
    @Setter
    @Id
    @Column(name = "level_id")
    private Long level_id;
    @Getter
    @Setter
    @Column(name = "level_value")
    private String level_value;
}
