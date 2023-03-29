package com.project.fenix.exceptions;

import org.springframework.http.HttpStatus;

public class ResponseError extends Exception {
    private HttpStatus status;

    public ResponseError(HttpStatus httpStatus, String message) {
        super(message);
        this.status = httpStatus;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
