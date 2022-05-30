package com.portfolioLucia.PortfolioLucia.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "experience")
public class Experience {
    @Getter
    @Setter
    @Id
    @Column(name = "experience_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long experience_id;
    @Getter
    @Setter
    @Column(name = "logo_url")
    private String logo_url;
    @Getter
    @Setter
    @Column(name = "title")
    private String title;
    @Getter
    @Setter
    @Column(name = "start_period")
    private String start_period;
    @Getter
    @Setter
    @Column(name = "finish_period")
    private String finish_period;
    @Getter
    @Setter
    @Column(name = "site")
    private String site;
    @Getter
    @Setter
    @Column(name = "description")
    private String description;
    @Getter
    @Setter
    @Column(name = "author")
    private String author;
    @Getter
    @Setter
    @Column(name = "experience_Img_deletehash")
    private String experience_Img_deletehash;
}
