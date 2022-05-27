package com.portfolioLucia.PortfolioLucia.models;

import lombok.Getter;
import lombok.Setter;

public class AuthenticationRequest {

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;
}
