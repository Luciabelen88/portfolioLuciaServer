package com.portfolioLucia.PortfolioLucia.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "education")
public class Education {
    @Getter
    @Setter
    @Id
    @Column(name = "education_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long education_id;
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
    @Column(name = "img_deletehash")
    private String education_Img_deletehash;

}
