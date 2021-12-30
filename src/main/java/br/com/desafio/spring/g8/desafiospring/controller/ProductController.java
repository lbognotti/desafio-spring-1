package br.com.desafio.spring.g8.desafiospring.controller;

import br.com.desafio.spring.g8.desafiospring.advice.handler.ProductNotFoundException;
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

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody List<Product> products) throws IOException {
        this.productService.createProduct(products);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Product>> findAll() throws IOException {
        return ResponseEntity.ok(this.productService.findAllProduct());
    }

    @GetMapping("/articles")
    public ResponseEntity<List<Product>> findAllProductFilter(@RequestParam Map<String, String> allParams) throws IOException {
        return ResponseEntity.ok(this.productService.findFilter(allParams));
    }
}
