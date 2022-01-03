package br.com.desafio.spring.g8.desafiospring.advice.handler;

/**
 * @author Lucas Bognotti
 * @description Exceção criada para ser lançada quando um produto não for encontrada na base de dados (JSON).
 */
public class ProductNotFoundException extends RuntimeException {
    static final long serialVersionUID = -7034897190745766939L;

    public ProductNotFoundException(String message) {
        super(message);
    }
}