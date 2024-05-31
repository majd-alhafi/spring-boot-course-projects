package com.example.restcrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleStudentNotFoundException(StudentNotFoundException e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(e.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleGenericException(Exception e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(e.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
