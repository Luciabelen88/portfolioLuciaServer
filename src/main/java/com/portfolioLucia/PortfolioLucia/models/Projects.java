package com.portfolioLucia.PortfolioLucia.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Projects {
    @Getter
    @Setter
    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long project_id;
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
    @Column(name = "date")
    private String date;
    @Getter
    @Setter
    @Column(name = "project_img")
    private String project_img;
    @Getter
    @Setter
    @Column(name = "link_github")
    private String link_github;
    @Getter
    @Setter
    @Column(name = "author")
    private String author;
    @Getter
    @Setter
    @Column(name = "img_deletehash")
    private String img_deletehash;
}
