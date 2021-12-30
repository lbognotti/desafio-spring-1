package br.com.desafio.spring.g8.desafiospring.service;

import br.com.desafio.spring.g8.desafiospring.advice.handler.ProductNotFoundException;
import br.com.desafio.spring.g8.desafiospring.entity.Product;
import br.com.desafio.spring.g8.desafiospring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(List<Product> products) throws IOException {
        for (Product product : products) {
            try {
                this.productRepository.save(product);
            } catch (IOException e) {
                throw new IOException("Erro ao cadastrar o product" + product.getName());
            }
        }
    }

    public List<Product> findAllProduct() throws IOException {
        List<Product> products = null;
        try {
            products = this.productRepository.findAllAvailableProduct();
        } catch (IOException e) {
            throw new ProductNotFoundException(e.getMessage());
        }
       return products;
    }

    public List<Product> findFilter(Map<String, String> allParams) throws IOException {
        List<Product> products = this.productRepository.findAllAvailableProduct();
        for (Map.Entry<String, String> params : allParams.entrySet()) {
            switch (params.getKey()) {
                case "product":
                    products = this.productRepository.findAllProductByName(products, params.getValue());
                break;
                case "category":
                    products = this.productRepository.findAllProductByCategory(products, params.getValue());
                break;
                default:
                    throw new ProductNotFoundException("Product not found");
            }
        }
        return products;
    }
}
