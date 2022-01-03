package br.com.desafio.spring.g8.desafiospring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PurchaseDTO {
    @JsonProperty("articlesPurchaseRequest")
    public List<ProductDTO> articlesPurchaseRequest = null;
}