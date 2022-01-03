package br.com.desafio.spring.g8.desafiospring.dto;

import br.com.desafio.spring.g8.desafiospring.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ronaldd Pinho
 * @description Classe usada para mapear Arrays (Listas) de DTO e Entidades.
 */
public class ArrayMapper {

    /**
     * @author Ronaldd Pinho
     * @param productDtos Uma lista de DTOs de Produtos (ProductDTO)
     * @description Usa a API de Stream para mapear uma lista de DTOs de produtos para uma lista de entidades Produto
     * @return Uma lista da entidade Product.
     */
    public static List<Product> dtosToProducts(List<ProductDTO> productDtos) {
        return productDtos.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());
    }

    /**
     * @author Ronaldd Pinho
     * @param products Uma lista de objetos da entidade Produto
     * @description Usa a API de Stream para mapear uma lista de entidades de Produto para uma lista de DTOs de Produto
     * @return Uma lista de DTOs de Produto
     */
    public static List<ProductDTO> productsToDtos(List<Product> products) {
        return products.stream()
                .map(product -> ProductDTO.fromEntity(product))
                .collect(Collectors.toList());
    }
}
