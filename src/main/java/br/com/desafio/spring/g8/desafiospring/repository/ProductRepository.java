package br.com.desafio.spring.g8.desafiospring.repository;

import br.com.desafio.spring.g8.desafiospring.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ProductRepository implements IProductRepository<Product> {
    private List<Product> products = new ArrayList<Product>();
    private ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    private final String PATH = "products.json";

    @Override
    public void save(Product product) throws IOException {
        product.setProductId((long) products.size()+1);
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
    public List<Product> findAllCategoryProduct(String categoryName) throws IOException {
        List<Product> arrayProduct = this.findAllAvailableProduct();
        return arrayProduct.stream().filter(p -> p.getCategory().equals(categoryName)).collect(Collectors.toList());
    }

    @Override
    public List<Product> findAllProductTwoCategory(String p1, String p2) {
        return null;
    }

    @Override
    public List<Product> findAllProductDecreasingAlfa() {
        return null;
    }

    @Override
    public List<Product> findAllProductIncreasingAlfa() {
        return null;
    }

    @Override
    public List<Product> findAllProductDecreasingOrder() {
        return null;
    }

    @Override
    public List<Product> findAllProductIncreasingOrder() {
        return null;
    }
}
