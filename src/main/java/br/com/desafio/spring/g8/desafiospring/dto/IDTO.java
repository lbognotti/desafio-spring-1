package br.com.desafio.spring.g8.desafiospring.dto;

public interface IDTO<T> {
    T toEntity();
}