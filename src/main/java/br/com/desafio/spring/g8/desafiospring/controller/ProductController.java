package br.com.desafio.spring.g8.desafiospring.controller;

import br.com.desafio.spring.g8.desafiospring.dto.ArrayMapper;
import br.com.desafio.spring.g8.desafiospring.dto.CreateProductsDTO;
import br.com.desafio.spring.g8.desafiospring.dto.ListProductsDTO;
import br.com.desafio.spring.g8.desafiospring.entity.Product;
import br.com.desafio.spring.g8.desafiospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/insert-articles-request")
    public ResponseEntity<ListProductsDTO> create(@RequestBody CreateProductsDTO createProductsDTO) throws IOException {
        List<Product> products = ArrayMapper.dtosToProducts(createProductsDTO.getArticles());
        this.productService.createProduct(products);
        return ResponseEntity.ok(ListProductsDTO
                .builder()
                .articlesDTO(createProductsDTO.getArticles())
                .build());
    }

    @GetMapping("/articles")
    public ResponseEntity<List<Product>> findAllProductFilter(@RequestParam Map<String, String> allParams) throws IOException {
        return ResponseEntity.ok(this.productService.findFilter(allParams));
    }
}