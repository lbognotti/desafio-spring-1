package br.com.desafio.spring.g8.desafiospring.dto;

import br.com.desafio.spring.g8.desafiospring.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
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


        public class ProductDTO {
            private Long productId;
            private String name;
            private Integer quantity;
            @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
            private String category;
            private String brand;
            private BigDecimal price;
            private Boolean freeShipping;
            private String prestige;


        public static Product converte(ProductDTO dto){
            Product product = Product.builder()
                    .name(dto.getName())
                    .productId(dto.getProductId())
                    .quantity(dto.getQuantity())
                    .category(dto.getCategory())
                    .brand(dto.getBrand())
                    .price(dto.getPrice())
                    .freeShipping(dto.getFreeShipping())
                    .prestige(dto.getPrestige())
                    .build();

            return product;
        }

        public static ProductDTO converte(Product product){
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


        public static List<ProductDTO> converteListProductToDto(List<Product> products){
            return products.stream().map(p -> converte(p)).collect(Collectors.toList());
        }

        public static List<Product> converteListDtoToProduct(List<ProductDTO> dtos){
            return dtos.stream().map(d -> converte(d)).collect(Collectors.toList());
        }
}


