package br.com.desafio.spring.g8.desafiospring.dto;

import br.com.desafio.spring.g8.desafiospring.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements IDTO<Product> {
    private Long productId;
    private String name;
    private Integer quantity;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String category;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String brand;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private BigDecimal price;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Boolean freeShipping;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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

    public static ProductDTO fromEntity(Product product) {
        return ProductDTO.builder()
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
}
