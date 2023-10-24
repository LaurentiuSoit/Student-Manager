package com.student.student.controllers;

import com.student.student.exceptions.StudentNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {StudentNotFoundException.class})
    protected ResponseEntity<Object> handleStudentNotFoundException(RuntimeException runtimeException, WebRequest webRequest){
        return handleExceptionInternal(runtimeException, runtimeException.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
    }
}
