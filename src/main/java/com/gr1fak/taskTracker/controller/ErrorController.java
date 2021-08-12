package com.gr1fak.taskTracker.controller;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(IOException.class)
    public ResponseEntity handleNotFoundEx(NotFoundException e){
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
