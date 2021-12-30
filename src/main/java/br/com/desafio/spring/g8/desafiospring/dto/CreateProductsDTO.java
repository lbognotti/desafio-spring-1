package br.com.desafio.spring.g8.desafiospring.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateProductsDTO {

    @JsonProperty("articles")
    public List<ProductDTO> articles = null;

}