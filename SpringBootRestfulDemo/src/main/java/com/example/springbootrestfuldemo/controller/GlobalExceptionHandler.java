package com.example.springbootrestfuldemo.controller;

import com.example.springbootrestfuldemo.exception.AgeNotValidException;
import com.example.springbootrestfuldemo.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(StudentController.class);
    @ExceptionHandler(AgeNotValidException.class)
    public ResponseEntity<ErrorResponse> exceptionHandlerAgeNotValid(Exception ex) {
        logger.error("age is not valid, should larger than 0");
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
