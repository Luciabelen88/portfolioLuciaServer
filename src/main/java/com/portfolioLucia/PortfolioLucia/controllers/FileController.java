package com.portfolioLucia.PortfolioLucia.controllers;

import com.portfolioLucia.PortfolioLucia.dao.AuthorDao;
import com.portfolioLucia.PortfolioLucia.dao.EducationDao;
import com.portfolioLucia.PortfolioLucia.dao.ExperienceDao;
import com.portfolioLucia.PortfolioLucia.dao.ProjectsDao;
import com.portfolioLucia.PortfolioLucia.models.Author;
import com.portfolioLucia.PortfolioLucia.models.Education;
import com.portfolioLucia.PortfolioLucia.models.Experience;
import com.portfolioLucia.PortfolioLucia.models.Projects;
import com.portfolioLucia.PortfolioLucia.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;


import java.io.IOException;

import java.net.URISyntaxException;

import java.util.HashMap;



@RestController
public class FileController {


    @Autowired
    ImageService imageService;

    @Autowired
    AuthorDao authorDao;

    @Autowired
    ExperienceDao experienceDao;

    @Autowired
    ProjectsDao projectsDao;

    @Autowired
    EducationDao educationDao;

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("uploadFile")
    public HashMap uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("typeEntity") String idEntity, @RequestParam("idEntity") String identificador) throws URISyntaxException {

        String fileName = identificador;

         Mono<HashMap> response = imageService.uploadImgToImgur(file, fileName);

        HashMap respuesta = (HashMap) response.block().get("data");


        if (idEntity.equals("profile")) {

            Author author = authorDao.getAuthor().get(0);
            author.setDeletehash_profile(respuesta.get("deletehash").toString());
            author.setProfile_img(respuesta.get("link").toString());
            authorDao.updateAuthor(author);

        }
        if (idEntity.equals("background")) {
            Author author = authorDao.getAuthor().get(0);
            author.setDeletehash_background(respuesta.get("deletehash").toString());
            author.setBackground_img(respuesta.get("link").toString());
            authorDao.updateAuthor(author);
        }

        if (idEntity.equals("education")) {
            Education education = educationDao.getById(Long.valueOf(fileName.toString()).longValue());
            education.setEducation_Img_deletehash(respuesta.get("deletehash").toString());
            education.setLogo_url(respuesta.get("link").toString());
            educationDao.updateEducation(education);

            System.out.println(fileName);
            System.out.println(Long.valueOf(fileName).longValue());

        }
        if (idEntity.equals("experience")) {

            Experience experience = experienceDao.getById(Long.valueOf(fileName.toString()).longValue());
            experience.setExperience_Img_deletehash(respuesta.get("deletehash").toString());
            experience.setLogo_url(respuesta.get("link").toString());
            experienceDao.updateExperience(experience);
        }
        if (idEntity.equals("project")) {
            Projects projects = projectsDao.getById(Long.valueOf(fileName.toString()).longValue());
            projects.setImg_deletehash(respuesta.get("deletehash").toString());
            projects.setProject_img(respuesta.get("link").toString());
            projectsDao.updateProject(projects);
        }

     return respuesta;
    }


    @CrossOrigin(origins = "http://localhost:4200" )
    @RequestMapping(value="deleteFile/{deletehash}", method = RequestMethod.DELETE)
    public HashMap deleteFile(@PathVariable String deletehash) throws IOException, URISyntaxException {


        Mono<HashMap> response = imageService.deleteImgToImgur(deletehash);

        HashMap respuesta = (HashMap) response.block();

        return respuesta;
    }
}