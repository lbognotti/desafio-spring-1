package br.com.desafio.spring.g8.desafiospring.dto;

import br.com.desafio.spring.g8.desafiospring.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompleteProductDTO implements IDTO<Product> {
    private Long productId;
    private String name;
    private Integer quantity;
    private String category;
    private String brand;
    private BigDecimal price;
    private Boolean freeShipping;
    private String prestige;

    @Override
    public Product toEntity() {
        return Product.builder()
                .name(this.getName())
                .productId(this.getProductId())
                .quantity(this.getQuantity())
                .category(this.getCategory())
                .brand(this.getBrand())
                .price(this.getPrice())
                .freeShipping(this.getFreeShipping())
                .prestige(this.getPrestige())
                .build();
    }

    public static CompleteProductDTO fromEntity(Product product) {
        return CompleteProductDTO.builder()
                .name(product.getName())
                .productId(product.getProductId())
                .quantity(product.getQuantity())
                .category(product.getCategory())
                .brand(product.getBrand())
                .price(product.getPrice())
                .freeShipping(product.getFreeShipping())
                .prestige(product.getPrestige())
                .build();
    }

    public static List<CompleteProductDTO> converte(List<Product> usuarios){
        return usuarios.stream().map(u -> CompleteProductDTO.fromEntity(u)).collect(Collectors.toList());
    }
}