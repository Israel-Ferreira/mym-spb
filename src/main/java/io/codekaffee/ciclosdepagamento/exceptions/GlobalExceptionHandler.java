package io.codekaffee.ciclosdepagamento.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public StandardError handleObjectNotFoundException(ObjectNotFoundException e){
        return new StandardError(e.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(Exception.class)
    public StandardError handleException(Exception e){
        return new StandardError(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY.value());
    }
}
