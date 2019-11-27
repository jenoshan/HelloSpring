package com.example.HelloSpring.Service;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {
    private T payload;
    private int status;
    private String message;
    private String error;

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ApiResponse(T payload) {
        this.payload = payload;
        this.status = HttpStatus.OK.value();
        this.message = HttpStatus.OK.name();
    }

    public ApiResponse(T payload, HttpStatus success) {
        this.payload = payload;
        this.status = success.value();
        this.message = success.name();
    }

    public ApiResponse(T payload, HttpStatus status, String message) {
        this.payload = payload;
        this.status = status.value();
        this.error = status.name();
        this.message = message;
    }

    public ApiResponse(HttpStatus status, String message) {
        this.message = message;
        if (status.isError()) {
            this.error = status.name();
        }
        this.status = status.value();
    }
}
