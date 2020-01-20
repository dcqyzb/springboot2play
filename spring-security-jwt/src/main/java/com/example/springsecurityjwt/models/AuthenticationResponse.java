package com.example.springsecurityjwt.models;

/**
 * @author DC
 * @description
 * @date 2020/1/20
 */
public class AuthenticationResponse {

    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
