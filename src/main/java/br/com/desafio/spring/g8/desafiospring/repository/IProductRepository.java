package br.com.desafio.spring.g8.desafiospring.repository;

import br.com.desafio.spring.g8.desafiospring.entity.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface IProductRepository<T> {
        void save(T t) throws IOException;
        List<T> findAllAvailableProduct() throws IOException;
        List<T> findAllProductByName(List<Product> products, String productName) throws IOException;
        List<T> findAllProductByCategory(List<Product> products, String categoryName) throws IOException;
        List<T> findAllProductByBrand(String brandName) throws IOException;
        List<T> findAllProductByPrice(BigDecimal priceValue) throws IOException;
        List<T> findAllProductByFreeShipping(Boolean value) throws IOException;
        List<T> findAllProductByPrestige(String prestige) throws IOException;
}
