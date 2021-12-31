package br.com.desafio.spring.g8.desafiospring.service;

import br.com.desafio.spring.g8.desafiospring.advice.handler.ProductNotFoundException;
import br.com.desafio.spring.g8.desafiospring.entity.Product;
import br.com.desafio.spring.g8.desafiospring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
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
        List<Product> products;
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
            String filterName = params.getKey();
            String filterValue = params.getValue();
            products = this.choiceFilter(filterName, filterValue, products);
        }
        return products;
    }

    public List<Product> choiceFilter (String filterName, String filterValue, List<Product> products) throws IOException{
        switch (filterName.toLowerCase()) {
            case "product":
                products = productRepository.findAllProductByName(products, filterValue);
                break;
            case "category":
                products = productRepository.findAllProductByCategory(products,  filterValue);
                break;
            case "brand":
                products = productRepository.findAllProductByBrand(products,  filterValue);
                break;
            case "price":
                products = productRepository.findAllProductByPrice(products, new BigDecimal(filterValue));
                break;
            case "prestige":
                products = productRepository.findAllProductByPrestige(products,  filterValue);
                break;
            case "order":
                products = this.useOrder(products, filterValue);
                break;
            default:
                System.out.println("Nenhum filtro aplicado");
        }
        return products;
    }

    public List<Product> useOrder(List<Product> products, String orderValue) {
        switch (orderValue) {
            case "0":
                products = this.productRepository.orderAlphabeticalCrescent(products);
            break;
            case "1":
                products = this.productRepository.orderAlphabeticalDescending(products);
                break;
            case "2":
                products = this.productRepository.orderPriceDescending(products);
                break;
            case "3":
                products = this.productRepository.orderPriceCrescent(products);
                break;
            default:
        }
        return products;
    }
}
