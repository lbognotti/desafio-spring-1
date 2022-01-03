package br.com.desafio.spring.g8.desafiospring.advice;

import br.com.desafio.spring.g8.desafiospring.advice.handler.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;

/**
 * @author Lucas Bognotti
 * @description Classe de Advice para tratamento de exceções nas camadas do sistema.
 */
@ControllerAdvice
public class PersistenceExceptionAdvice {

    /**
     * @author Lucas Bognotti
     * @description Captura exceções de IOException e retorna BAD REQUEST (400).
     * @param exception a exceção capturada
     * @param request contexto da requisição
     * @return Resposta da requisição com um Bad Request
     */
    @ExceptionHandler(value = IOException.class)
    protected ResponseEntity<Object> handleIOExpection(IOException exception, WebRequest request) {
       String bodyOfResponse = exception.getMessage();
       return ResponseEntity.badRequest().body(bodyOfResponse);
    }

    /**
     * @author Lucas Bognotti
     * @description Captura exceções de ProductNotFoundException e retorna NOT FOUND (404).
     * @param exception a exceção capturada
     * @param request contexto da requisição
     * @return Resposta da requisição com um Not Found
     */
    @ExceptionHandler(value = ProductNotFoundException.class)
    protected ResponseEntity<Object> handleProductNotFoundExpection(ProductNotFoundException exception, WebRequest request) {
        return ResponseEntity.notFound().build();
    }
}