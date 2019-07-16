package com.spring.demo.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RequestFileNotFoundException extends Exception {

    public RequestFileNotFoundException(String message){

        super(message);
    }

    public RequestFileNotFoundException(String message, Throwable cause){

        super(message, cause);
    }
}
