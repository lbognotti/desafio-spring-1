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


// Entendi que O product repository faz leitura e gravacao de dados em persistencia - Wolsen
@Component

public class ProductRepository implements IProductRepository<Product> {
    private List<Product> products = new ArrayList<>(); //conferir se nao houve alteracao
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
    public List<Product> findAllProductByName(List<Product> products, String productName) throws IOException {
        return products.stream()
                .filter(product -> product.getName().equals(productName))
                .collect(Collectors.toList());
    }

    @Override

    public List<Product> findAllProductByName(String productName) {

        return null;
    }

    @Override
    public List<Product> findAllProductByCategory(String categoryName) {

        return null;
    }

    @Override
    public List<Product> findAllProductByBrand(String brandName) {
        return null;
    }

    @Override
    public List<Product> findAllProductByPrice(BigDecimal valuePrice) {
        return null;
    }

    @Override
    public List<Product> findAllProductIsFreeShipping(Boolean shipping) {
        return null;
    }

    @Override
    public List<Product> findAllProductByPrestige(String prestige) {
        return null;
    }

    //Acredito que esses metodos estao sendo subistituidos por outros com melhores nomes
    @Override
    public List<Product> findProductName(String productName) {
        return List;
    }

    @Override
    public List<Product> findCategory(String categoryName) {
        return null;
    }

    @Override
    public List<Product> findBrand(String brandName) {
        return null;
    }

    @Override
    public List<Product> findPrice(BigDecimal valuePrice) {
        return null;
    }

    @Override
    public List<Product> findFreeShipping(Boolean price) {
        return null;
    }

    @Override
    public List<Product> findPrestige(String prestige) {
        return null;
    }
//fim dos metodos com nomes antigos



    @Override
    public List<Product> findAllProductByCategory(List<Product> products, String categoryName) throws IOException {
        return products.stream()
                .filter(product -> product.getCategory().equals(categoryName))
                .collect(Collectors.toList());

    }

    @Override
    public List<Product> findAllProductByBrand(String brandName) throws IOException {
        return null;
    }

    @Override
    public List<Product> findAllProductByPrice(BigDecimal priceValue) throws IOException {
        return null;
    }

    @Override
    public List<Product> findAllProductByFreeShipping(Boolean value) throws IOException {
        return null;
    }

    @Override
    public List<Product> findAllProductByPrestige(String prestige) throws IOException {
        return null;
    }





}
