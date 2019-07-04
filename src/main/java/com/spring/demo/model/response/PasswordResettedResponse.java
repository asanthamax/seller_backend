package com.spring.demo.model.response;

import java.util.Date;

public class PasswordResettedResponse {

    private String message;
    private boolean status;
    private Date datetime;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public PasswordResettedResponse() {

    }

    public PasswordResettedResponse(String message, boolean status, Date datetime) {

        this.message = message;
        this.status = status;
        this.datetime = datetime;
    }
}
