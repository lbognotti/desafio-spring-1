package br.com.desafio.spring.g8.desafiospring.repository;

import java.io.IOException;
import java.util.List;

public interface IProductRepository<T> {
        void save(T t) throws IOException;
        List<T> findAllAvailableProduct() throws IOException;
        List<T> findAllCategoryProduct(String categoryName) throws IOException;
        List<T> findAllProductTwoCategory(String p1,String p2);
        List<T> findAllProductDecreasingAlfa();
        List<T> findAllProductIncreasingAlfa();
        List<T> findAllProductDecreasingOrder();
        List<T> findAllProductIncreasingOrder();

}
