package com.spring.demo.errors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class RestExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(value = {IOException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse badRequest(Exception ex){

        logger.error("Bad Request", ex.getMessage());
        return new ErrorResponse(400, "Bad Request");

    }

    @ExceptionHandler(value = {RequestNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse unknownException(RequestNotFoundException ex){

        logger.error("Resource not found", ex.getMessage());
        return new ErrorResponse(404, "Resource not found");
    }
}
