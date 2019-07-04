package com.spring.demo.model.request;

public class PasswordResetRequest {

    private String password;

    private String confirmPassword;

    private Long userId;

    private String token;

    private Long Id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public PasswordResetRequest() {

    }

    public PasswordResetRequest(String password, String confirmPassword, Long userId, String token, Long id) {

        this.password = password;
        this.confirmPassword = confirmPassword;
        this.userId = userId;
        this.token = token;
        this.Id = id;
    }
}
