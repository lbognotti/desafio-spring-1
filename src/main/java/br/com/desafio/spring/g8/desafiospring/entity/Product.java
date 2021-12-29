package br.com.desafio.spring.g8.desafiospring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    private Long productId;
    private String name;
    private String category;
    private String brand;
    private BigDecimal price;
    private  Integer quantity;
    private  Boolean freeShipping;
    private String prestige;
}
