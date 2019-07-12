package com.spring.demo.errors;

public class RequestNotFoundException extends Exception {

    public RequestNotFoundException(String message){

        super(message);
    }

    public RequestNotFoundException(String message, Throwable throwable){

        super(message, throwable);
    }
}
