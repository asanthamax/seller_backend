package com.spring.demo.errors;

import java.util.Date;

public class ExceptionResponse {

    private Date timeStamp;

    private String message;

    private String details;

    private String httpCodeMessage;

    public ExceptionResponse(Date timeStamp, String message, String details, String httpCodeMessage) {

        super();
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
        this.httpCodeMessage = httpCodeMessage;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getHttpCodeMessage() {
        return httpCodeMessage;
    }
}
