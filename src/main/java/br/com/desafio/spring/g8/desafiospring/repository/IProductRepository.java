package br.com.desafio.spring.g8.desafiospring.repository;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface IProductRepository<T> {
        void save(T t) throws IOException;
        List<T> findAllAvailableProduct() throws IOException;
        List<T> findAllCategoryProduct(String categoryName) throws IOException;
        //List<T> findAllProductTwoCategory(String p1,String p2);
        //List<T> findAllProductDecreasingAlfa();
        //List<T> findAllProductIncreasingAlfa();
        //List<T> findAllProductDecreasingOrder();
        //List<T> findAllProductIncreasingOrder();
        List<T> findProductName (String productName);
        List<T> findCategory (String categoryName);
        List<T> findBrand (String brandName);
        List<T> findPrice (BigDecimal valuePrice);
        List<T> findFreeShipping (Boolean price);
        List<T> findPrestige (String prestige);

        void indicaFiltragem (String filtro, boolean confirm);


        //6Metodos
        //metodo transforma em true = recebe string e boolean


        //transforma 1
        //trasnsforma 2
        //trata

        // filtra 1 case
        //filtra 2 case


        //filtro 1 pega lista completa retorna a lista filtrada;
        //fitro 2 pega a lista filtrada retorna listra refiltrada;


}
