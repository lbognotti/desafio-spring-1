package br.com.desafio.spring.g8.desafiospring.dto;

/**
 * @author Ronaldd Pinho
 * @description Interface base para DTOs que conecta um DTO a uma entidade.
 * @param <T> Tipo da entidade.
 */
public interface IDTO<T> {

    /**
     * @author Ronaldd Pinho
     * @description interface contendo um método de conversão para uma entidade qualquer.
     * @return a instância da entidade.
     */
    T toEntity();
}