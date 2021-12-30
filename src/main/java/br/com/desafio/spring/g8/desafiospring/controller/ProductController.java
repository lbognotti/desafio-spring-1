package br.com.desafio.spring.g8.desafiospring.controller;

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
    public ResponseEntity<Object> create(@RequestBody List<Product> products) throws IOException {
        this.productService.createProduct(products);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/articles")
    public ResponseEntity<List<Product>> findAllProductFilter(@RequestParam Map<String, String> allParams) throws IOException {
        return ResponseEntity.ok(this.productService.findFilter(allParams));

//    //Teste de DTO - Get
//    @GetMapping("/findAllDto")
//    public ResponseEntity<ListProductsDTO> findAllDto() throws IOException {
//        List<ProductDTO> productsDto = this.productService.findAllProduct()
//                .stream()
//                .map(product -> ProductDTO.fromEntity(product))
//                .collect(Collectors.toList());
//
//        ListProductsDTO responseBody = ListProductsDTO.builder()
//                .articlesDTO(productsDto)
//                .build();
//
//        return ResponseEntity.ok(responseBody);
//    }
//
//    //Teste de DTO - Post
//    @PostMapping("/createDto")
//    public ResponseEntity<Object> createDto(@RequestBody CreateProductsDTO createProductsDTO) throws IOException {
//        List<Product> products = createProductsDTO.getArticles()
//                .stream()
//                .map(article -> article.toEntity())
//                .collect(Collectors.toList());
//
//        this.productService.createProduct(products);
//        return ResponseEntity.ok().build();
//    }
    }
}