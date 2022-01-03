package br.com.desafio.spring.g8.desafiospring.service;

import br.com.desafio.spring.g8.desafiospring.advice.handler.ProductNotFoundException;
import br.com.desafio.spring.g8.desafiospring.entity.Product;
import br.com.desafio.spring.g8.desafiospring.entity.Ticket;
import br.com.desafio.spring.g8.desafiospring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * @author Lucas Bognotti
     * @param products - lista de produtos para salvar no products.json
     * @throws IOException - erro ao escrever ao salvar no arquivo
     * @description - recebe uma lista de product, a percorre e salva produto por produto
     */
    public void createProduct(List<Product> products) throws IOException {
        for (Product product : products) {
            try {
                this.productRepository.save(product);
            } catch (IOException e) {
                throw new IOException("Erro ao cadastrar o product" + product.getName());
            }
        }
    }

    /**
     * @author Lucas Bognotti
     * @description - recebe um map de chave e valor, percorre o map  e usa o metodo escolhe o filtro correspondente para essa chave e valor
     * @param allParams - todos os query parms da requisicao
     * @return - retorna uma lista de produtos filtrada por todos os filtros aplicados
     * @throws IOException - excessao ao tentar ler o arquivo products.json
     */
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
            case "freeShipping":
                    products = productRepository.findAllProductByFreeShipping(products, Boolean.valueOf(filterValue));
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

    public Ticket purchaseRequest(List<Product> products) throws IOException {
        try{
            List <Product> productList = this.productRepository.findAllAvailableProduct();
            List <Product> purchaseList = new ArrayList<>();
            for (Product product : products){
                purchaseList.add(this.productRepository.checkProductExist(product.getProductId(), product.getName(), product.getBrand(), productList));
            }
            double totalValue = purchaseList.stream().mapToDouble(product -> product.getPrice().doubleValue()*product.getQuantity()).reduce((acc,product)->acc+product).getAsDouble();
            Ticket ticket = new Ticket(1L, purchaseList, totalValue);
            return ticket;
        }catch(IOException e){
            throw new ProductNotFoundException("Produto não encontrado.");
        }
    }
}