package br.com.desafio.spring.g8.desafiospring.repository;

import br.com.desafio.spring.g8.desafiospring.entity.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

//Interface que sera usada no ProductRepository - Wolsen

public interface IProductRepository<T> {
        void save(T t) throws IOException;
        List<T> findAllAvailableProduct() throws IOException;
        List<T> findAllCategoryProduct(String categoryName) throws IOException;
        //List<T> findAllProductTwoCategory(String p1,String p2);
        //List<T> findAllProductDecreasingAlfa();
        //List<T> findAllProductIncreasingAlfa();
        //List<T> findAllProductDecreasingOrder();
        //List<T> findAllProductIncreasingOrder();

//
//        List<T> findAllProductByName (String productName);
//        List<T> findAllProductByCategory (String categoryName);
//        List<T> findAllProductByBrand (String brandName);
//        List<T> findAllProductByPrice (BigDecimal valuePrice);
//        List<T> findAllProductIsFreeShipping (Boolean shipping);
//        List<T> findAllProductByPrestige (String prestige);
//        //List<T> choiceFilter(String filterName);
//        //void indicaFiltragem (String filtro, boolean confirm);





        //6Metodos
        //metodo transforma em true = recebe string e boolean


        //transforma 1
        //trasnsforma 2
        //trata

        // filtra 1 case
        //filtra 2 case


        //filtro 1 pega lista completa retorna a lista filtrada;
        //fitro 2 pega a lista filtrada retorna listra refiltrada;



        List<T> findAllProductByName(List<Product> products, String productName) throws IOException;
        List<T> findAllProductByCategory(List<Product> products, String categoryName) throws IOException;
        List<T> findAllProductByBrand(String brandName) throws IOException;
        List<T> findAllProductByPrice(BigDecimal priceValue) throws IOException;
        List<T> findAllProductByFreeShipping(Boolean value) throws IOException;
        List<T> findAllProductByPrestige(String prestige) throws IOException;

}
