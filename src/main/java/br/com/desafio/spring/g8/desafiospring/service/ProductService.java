package br.com.desafio.spring.g8.desafiospring.service;

import br.com.desafio.spring.g8.desafiospring.advice.handler.ProductNotFoundException;
import br.com.desafio.spring.g8.desafiospring.entity.Product;
import br.com.desafio.spring.g8.desafiospring.repository.ProductRepository;
import ch.qos.logback.core.net.SyslogOutputStream;
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



    // /api/v1/articles?product=productName&amp;brand=brandName
    //adicionarIgonoreCase
    //queremos utilizar o dto para realizar as filtragens todas, para no final retornar ele para onde for necessario
    // List<ProductDTO> listForFilter;

    public void choiceFilter (String filterName, String filterValue) {
        switch (filterName.toLowerCase()) {

            case "name":
                productRepository.findAllProductByName(String filterValue);
                break;
            case "category":
                productRepository.findAllProductByCategory(String filterValue);
                break;
            case "brand":
                productRepository.findAllProductByBrand(String filterValue);
                break;
            case "price":
                productRepository.findAllProductByPrice();
                break;
            case "prestige":
                productRepository.findAllProductByPrestige(String filterValue);
                break;
            default:
                System.out.println("Nenhum filtro aplicado");
        }
    }

        /*
        List<Product> produtoss = productRepository.findAllAvailableProduct();
        produtoss = produtoss.choiceFilter(parametro 1, filterValue);
        produtoss = produtoss.choiceFilter(parametro 2);
        Lista criada;
        listacriada = listadeprodutos.filtra(lista criada);
        listacriada
        */

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
