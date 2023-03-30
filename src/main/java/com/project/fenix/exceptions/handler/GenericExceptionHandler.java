package com.project.fenix.exceptions.handler;


import com.project.fenix.exceptions.GenericException;
import com.project.fenix.exceptions.ResponseError;
import com.project.fenix.exceptions.ExceptionResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(ResponseError.class)
    public ResponseEntity<ExceptionResponse> userNotFoundException(ResponseError exception) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder().mensaje(exception.getMessage()).build();
        ResponseEntity<ExceptionResponse> response = new ResponseEntity<>(exceptionResponse, exception.getStatus());
        return response;
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ExceptionResponse> genericException(GenericException exception) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder().mensaje(exception.getMessage()).build();
        ResponseEntity<ExceptionResponse> response = new ResponseEntity<>(exceptionResponse, exception.getStatus());
        return response;
    }

    @ExceptionHandler({DataIntegrityViolationException.class, SQLException.class})
    public ResponseEntity<ExceptionResponse> dataIntegrityViolationException(SQLException exception) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder().mensaje(exception.getMessage()).build();
        ResponseEntity<ExceptionResponse> response = new ResponseEntity<>(exceptionResponse, HttpStatus.FAILED_DEPENDENCY);
        return response;
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<ExceptionResponse> nullPointerException(NullPointerException exception) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder().mensaje(exception.getMessage()).build();
        ResponseEntity<ExceptionResponse> response = new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ExceptionResponse> runtimeException(RuntimeException exception) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder().mensaje(exception.getMessage()).build();
        ResponseEntity<ExceptionResponse> response = new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }
}
