package io.codekaffee.ciclosdepagamento.exceptions;


import org.springframework.data.mapping.MappingException;
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


    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @ExceptionHandler(MappingException.class)
    public StandardError handleMappingException(MappingException e){
        e.printStackTrace();
        return new StandardError(e.getLocalizedMessage(), HttpStatus.NOT_IMPLEMENTED.value());
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(Exception.class)
    public StandardError handleException(Exception e){
        System.out.println(e.getLocalizedMessage());
        return new StandardError(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY.value());
    }
}
