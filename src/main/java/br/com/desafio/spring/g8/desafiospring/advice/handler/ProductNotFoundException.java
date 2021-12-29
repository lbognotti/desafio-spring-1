package br.com.desafio.spring.g8.desafiospring.advice.handler;

public class ProductNotFoundException extends RuntimeException {
    static final long serialVersionUID = -7034897190745766939L;

    public ProductNotFoundException(String message) {
        super(message);
    }
}
