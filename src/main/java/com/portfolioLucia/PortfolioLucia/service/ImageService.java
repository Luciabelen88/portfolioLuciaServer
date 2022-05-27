package com.portfolioLucia.PortfolioLucia.service;


import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;


@Service
public class ImageService {


    @Value("${imgurToken}")
    private String MY_SECRET_TOKEN;


    private final WebClient webClient;

    public ImageService(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://api.imgur.com/3/").build();
    }

    public Mono<HashMap> uploadImgToImgur(MultipartFile file, String nombreArchivo) {

        String fileName = nombreArchivo;

        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        builder.part("image", file.getResource());
        builder.part("title", fileName);

        Mono<HashMap> httpStatusMono = webClient.post()
                .uri("upload")
                .header("Authorization", MY_SECRET_TOKEN)
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromMultipartData(builder.build()))
                .exchangeToMono(response -> {
                    if (response.statusCode().equals(HttpStatus.OK)) {
                        return response.bodyToMono(HashMap.class);

                    } else {
                        throw new ServiceException("Error uploading image");
                    }
                });

          return httpStatusMono;
    }

    public Mono<HashMap> deleteImgToImgur(String deletehash) {

        Mono<HashMap> httpStatusMono = webClient.delete()
                .uri("image/" + deletehash)
                .header("Authorization", MY_SECRET_TOKEN)
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(response -> {
                    if (response.statusCode().equals(HttpStatus.OK)) {
                        return response.bodyToMono(HashMap.class);
                    } else {
                        throw new ServiceException("Error deleting image");
                    }
                });
        return httpStatusMono;
    }


}
