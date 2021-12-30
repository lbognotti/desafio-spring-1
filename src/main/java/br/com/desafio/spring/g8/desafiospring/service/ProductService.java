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

    public List<Product> choiceFilter (String filterName, String filterValue, List<Product> products) throws IOException{
        switch (filterName.toLowerCase()) {

            case "name":
                products = productRepository.findAllProductByName(products, filterValue);
                break;
//            case "category":
//                productRepository.findAllProductByCategory(products,  filterValue);
//                break;
//            case "brand":
//                productRepository.findAllProductByBrand(products,  filterValue);
//                break;
////            case "price":
////                productRepository.findAllProductByPrice(products, filterValue);
////                break;
//            case "prestige":
//                productRepository.findAllProductByPrestige(products,  filterValue);
//                break;
            default:
                System.out.println("Nenhum filtro aplicado");

                //add trhows
//            default:
//                throw new ProductNotFoundException("Product not found");
        }
        return products;
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
            String filterName = params.getKey();
            String filterValue = params.getValue();
                   products = this.choiceFilter(filterName,filterValue, products);

        }
        return products;
    }
}
