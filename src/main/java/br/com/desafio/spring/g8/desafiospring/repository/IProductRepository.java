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
        List<T> findAllProductByBrand(List<Product> products, String brandName) throws IOException;
        List<T> findAllProductByPrice(List<Product> products, BigDecimal priceValue) throws IOException;
        List<T> findAllProductByFreeShipping(List<Product> products, Boolean value) throws IOException;
        List<T> findAllProductByPrestige(List<Product> products, String prestige) throws IOException;
        List<T> orderPriceCrescent(List<Product> productsList);
        List<T> orderPriceDescending(List<Product> productsList);
        List<T> orderAlphabeticalCrescent(List<Product> productList);
        List<T> orderAlphabeticalDescending(List<Product> productList);
}