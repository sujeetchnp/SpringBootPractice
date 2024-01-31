package com.sujeet.project.springboot.controllers;

import com.sujeet.project.springboot.exception.DataIntegrityViolationException;
import com.sujeet.project.springboot.exception.InvalidInputException;
import com.sujeet.project.springboot.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFoundException(ResourceNotFoundException e, HttpServletResponse res, HttpServletRequest req) {
        res.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return e.getMessage();
    }

    @ExceptionHandler(InvalidInputException.class)
    public String handleInvalidInputException(InvalidInputException e, HttpServletResponse res, HttpServletRequest req) {
        res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return e.getMessage();
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        return responseEntity;
    }

    @ExceptionHandler(Exception.class)
    public String handleInternalServerException(Exception e, HttpServletResponse res, HttpServletRequest req) {
        System.out.println("Some unknown error occurred");
        e.printStackTrace();
        res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return "Something went wrong";
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletResponse res, HttpServletRequest req) {
        res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return "Data integrity violation: " + e.getMessage();
    }

}
