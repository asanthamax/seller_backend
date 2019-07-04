package com.spring.demo.model.response;

public class ResetPasswordResponse {

    private Long id;

    private Long userId;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ResetPasswordResponse(Long id, String token, Long userId) {
        this.id = id;
        this.token = token;
        this.userId = userId;

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
