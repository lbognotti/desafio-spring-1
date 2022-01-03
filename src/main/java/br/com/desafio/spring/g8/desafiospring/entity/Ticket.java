package br.com.desafio.spring.g8.desafiospring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Ticket {
    private Long id;
    private List<Product> products;
    private double valorTotal;
}
