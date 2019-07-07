package com.spring.demo.errors;

public class RequestFileNotFoundException extends RuntimeException {

    public RequestFileNotFoundException(String message){

        super(message);
    }

    public RequestFileNotFoundException(String message, Throwable cause){

        super(message, cause);
    }
}
