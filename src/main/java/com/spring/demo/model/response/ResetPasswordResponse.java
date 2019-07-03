package com.spring.demo.model.response;

public class ResetPasswordResponse {

    private Long id;

    public ResetPasswordResponse(Long id, String token) {
        this.id = id;
        this.token = token;
    }

    public ResetPasswordResponse() {
    }

    public Long getId() {
        return id;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;
}
