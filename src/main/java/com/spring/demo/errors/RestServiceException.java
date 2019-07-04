package com.spring.demo.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class RestServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RestServiceException(RuntimeException ex){

        super(ex.getMessage());
    }

    public RestServiceException(String msg){

        super(msg);
    }
}
