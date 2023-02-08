package com.example.springbootrestfuldemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseMessage {

    private String message;

    @JsonProperty("data")
    private Object body;

    public ResponseMessage() {
    }

    public ResponseMessage(String message) {
        this.message = message;
    }

    public ResponseMessage(String message, Object body) {
        this.message = message;
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
