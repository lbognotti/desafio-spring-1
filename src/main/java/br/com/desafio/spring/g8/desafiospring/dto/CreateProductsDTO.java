package br.com.desafio.spring.g8.desafiospring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Ronaldd Pinho
 * @descritpion DTO para representar uma requisição de criação de uma lista de Produtos.
 */
@Data
public class CreateProductsDTO {
    @JsonProperty("articles")
    public List<ProductDTO> articles = null;
}