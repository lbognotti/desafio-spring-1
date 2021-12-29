package br.com.desafio.spring.g8.desafiospring.service;

import br.com.desafio.spring.g8.desafiospring.advice.handler.ProductNotFoundException;
import br.com.desafio.spring.g8.desafiospring.entity.Product;
import br.com.desafio.spring.g8.desafiospring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

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
}
