package br.com.desafio.spring.g8.desafiospring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ListProductsDTO {

    @JsonProperty("articlesDTO")
    List<ProductDTO> articlesDTO = null;
}
