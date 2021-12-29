package br.com.desafio.spring.g8.desafiospring.repository;

import java.util.List;

public interface IProductRepository<T> {
        void save(T t);
        List<T> findAllAvailableProduct();
        List<T> findAllCategoryProduct(String categoryName);
        List<T> findAllProductTwoCategory(String p1,String p2);
        List<T> findAllProductDecreasingAlfa();
        List<T> findAllProductIncreasingAlfa();
        List<T> findAllProductDecreasingOrder();
        List<T> findAllProductIncreasingOrder();

}
