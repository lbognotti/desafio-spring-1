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







        List<T> findAllProductByName(List<Product> products, String productName) throws IOException;
        List<T> findAllProductByCategory(List<Product> products, String categoryName) throws IOException;
        List<T> findAllProductByBrand(List<Product> products, String brandName) throws IOException;
        List<T> findAllProductByPrice(List<Product> products, BigDecimal priceValue) throws IOException;
        List<T> findAllProductByFreeShipping(List<Product> products, Boolean value) throws IOException;
        List<T> findAllProductByPrestige(List<Product> products, String prestige) throws IOException;

}
