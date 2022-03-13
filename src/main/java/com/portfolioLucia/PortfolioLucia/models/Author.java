package com.portfolioLucia.PortfolioLucia.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author {
    @Getter
    @Setter
    @Id
    @Column(name = "user_name")
    private String user_name;
    @Getter
    @Setter
    @Column(name = "password")
    private String password;
    @Getter
    @Setter
    @Column(name = "email")
    private String email;
    @Getter
    @Setter
    @Column(name = "complete_name")
    private String complete_name;
    @Getter
    @Setter
    @Column(name = "profession")
    private String profession;
    @Getter
    @Setter
    @Column(name = "profile_img")
    private String profile_img;
    @Getter
    @Setter
    @Column(name = "background_img")
    private String background_img;
    @Getter
    @Setter
    @Column(name = "cv_doc")
    private String cv_doc;
    @Getter
    @Setter
    @Column(name = "about_text")
    private String about_text;
    @Getter
    @Setter
    @Column(name = "date_birth")
    private String date_birth;
    @Getter
    @Setter
    @Column(name = "country")
    private String country;
    @Getter
    @Setter
    @Column(name = "city")
    private String city;

}
