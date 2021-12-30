package br.com.desafio.spring.g8.desafiospring.advice;

import br.com.desafio.spring.g8.desafiospring.advice.handler.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;

@ControllerAdvice
public class PersistenceExceptionAdvice {

    @ExceptionHandler(value = IOException.class)
    protected ResponseEntity<Object> handleIOExpection(IOException exception, WebRequest request) {
       String bodyOfResponse = exception.getMessage();
       return ResponseEntity.badRequest().body(bodyOfResponse);
    }

    @ExceptionHandler(value = ProductNotFoundException.class)
    protected ResponseEntity<Object> handleProductNotFoundExpection(ProductNotFoundException exception, WebRequest request) {
        return ResponseEntity.notFound().build();
    }
}