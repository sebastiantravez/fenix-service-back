package com.project.fenix.exceptions.handler;


import com.project.fenix.exceptions.ResponseError;
import com.project.fenix.exceptions.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(ResponseError.class)
    public ResponseEntity<ExceptionResponse> userNotFoundException(ResponseError exception) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder().mensaje(exception.getMessage()).build();
        ResponseEntity<ExceptionResponse> response = new ResponseEntity<>(exceptionResponse, exception.getStatus());
        return response;
    }

}
