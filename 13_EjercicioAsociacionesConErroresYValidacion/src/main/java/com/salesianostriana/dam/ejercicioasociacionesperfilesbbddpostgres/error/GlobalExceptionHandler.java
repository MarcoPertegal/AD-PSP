package com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProfesorNotFoundException.class)
    ProblemDetail handleProfesorNotFoundException(ProfesorNotFoundException p){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, p.getMessage());
        problemDetail.setTitle("aaa Profesor Not Found");
        problemDetail.setType(URI.create("https://api.ejercicioprueba.com/errors/not-found"));
        return problemDetail;
    }

    //para validaxion
    @ExceptionHandler(ProfesorNotFoundException.class)
    ProblemDetail handleMethodArgumentNotValid(ProfesorNombreNullException p){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_ACCEPTABLE, p.getMessage());
        problemDetail.setTitle("Profesor name cant be null");
        problemDetail.setType(URI.create("https://api.ejercicioprueba.com/errors/null"));
        return problemDetail;
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildApiErrorWithSubErrors("Validation error. Please check the sublist.", request, status, ex.getAllErrors());
    }

}
