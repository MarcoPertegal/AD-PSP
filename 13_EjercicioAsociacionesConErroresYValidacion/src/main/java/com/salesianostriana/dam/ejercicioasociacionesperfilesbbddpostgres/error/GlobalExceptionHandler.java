package com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
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

    @ExceptionHandler(ProfesorNotFoundException.class)
    ProblemDetail handleNombreNullException(ProfesorNombreNullException p){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, p.getMessage());
        problemDetail.setTitle("aaa Profesor Not Found");
        problemDetail.setType(URI.create("https://api.ejercicioprueba.com/errors/null"));
        return problemDetail;
    }
}
