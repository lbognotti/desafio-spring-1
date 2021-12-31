package br.com.desafio.spring.g8.desafiospring.repository;

import br.com.desafio.spring.g8.desafiospring.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ProductRepository implements IProductRepository<Product> {
    private List<Product> products = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    private final String PATH = "products.json";

    @Override
    public void save(Product product) throws IOException {
        product.setProductId((long) products.size() + 1);
        products.add(product);
        objectMapper.writeValue(new File(PATH), products);
    }

    @Override
    public List<Product> findAllAvailableProduct() throws IOException {
        File file = new File(PATH);
        FileInputStream is = new FileInputStream(file);
        products = Arrays.asList(objectMapper.readValue(is, Product[].class));
        return products;
    }

    @Override
    public List<Product> findAllProductByName(List<Product> products, String productName) throws IOException {
        return products.stream()
                .filter(product -> product.getName().equals(productName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findAllProductByCategory(List<Product> products, String categoryName) throws IOException {
        return products.stream()
                .filter(product -> product.getCategory().equals(categoryName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findAllProductByBrand(List<Product> products, String brandName) throws IOException {
        return products.stream()
                .filter(product -> product.getBrand().equals(brandName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findAllProductByPrice(List<Product> products, BigDecimal priceValue) throws IOException {
        return products.stream()
                .filter(product -> product.getPrice().equals(priceValue))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findAllProductByFreeShipping(List<Product> products, Boolean value) throws IOException {
        return products.stream()
                .filter(product -> product.getFreeShipping().equals(value))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findAllProductByPrestige(List<Product> products, String prestige) throws IOException {
        return products.stream()
                .filter(product -> product.getPrestige().equals(prestige))
                .collect(Collectors.toList());
    }

    public List<Product> orderPriceCrescent(List<Product> productsList) {
        Comparator<Product> comparatorByPrice = Comparator.comparing(product -> product.getPrice());
        productsList.sort(comparatorByPrice);
        return productsList;
    }

    public List<Product> orderPriceDescending(List<Product> productsList) {
        Comparator<Product> comparatorByPrice = Comparator.comparing(product -> 1 / product.getPrice().doubleValue());
        productsList.sort(comparatorByPrice);
        return productsList;
    }

    public List<Product> orderAlphabeticalCrescent(List<Product> productList) {
        Comparator<Product> comparatorByName = Comparator.comparing(product -> product.getName());
        productList.sort(comparatorByName);
        return productList;
    }

    public List<Product> orderAlphabeticalDescending(List<Product> productList) {
        Comparator<Product> comparatorByName = Comparator.comparing(product -> product.getName());
        productList.sort(comparatorByName);
        Collections.reverse(productList);
        return productList;
    }
}