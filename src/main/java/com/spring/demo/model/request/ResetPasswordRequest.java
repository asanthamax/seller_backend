package com.spring.demo.model.request;

public class ResetPasswordRequest {

    public ResetPasswordRequest(String email) {
        this.email = email;
    }

    public ResetPasswordRequest() {
    }

    public String getEmail() {

        return email;

    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

}
