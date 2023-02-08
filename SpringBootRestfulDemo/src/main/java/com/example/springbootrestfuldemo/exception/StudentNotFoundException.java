package com.example.springbootrestfuldemo.exception;

public class StudentNotFoundException extends RuntimeException{
    private String errorMessage;

    public StudentNotFoundException() {
        super();
    }

    public StudentNotFoundException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
