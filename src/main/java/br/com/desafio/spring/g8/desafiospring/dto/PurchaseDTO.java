package br.com.desafio.spring.g8.desafiospring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Vinicius Feitoza
 * @description DTO que representa o corpo da requisição de compra.
 */
@Data
public class PurchaseDTO {
    @JsonProperty("articlesPurchaseRequest")
    public List<ProductDTO> articlesPurchaseRequest = null;
}