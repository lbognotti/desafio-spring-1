package br.com.desafio.spring.g8.desafiospring.controller;

import br.com.desafio.spring.g8.desafiospring.dto.ProductDTO;
import br.com.desafio.spring.g8.desafiospring.entity.Product;
import br.com.desafio.spring.g8.desafiospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController()
@RequestMapping("/product")
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

    //Teste de DTO - Get
    @GetMapping("/findAllDto")
    public ResponseEntity<List<ProductDTO>> findAllDto() throws IOException {
        return ResponseEntity.ok(ProductDTO.mapearConverte(this.productService.findAllProduct()));
    }

    //Teste de DTO - Post
    @PostMapping("/createDto")
    public ResponseEntity<Object> createDto(@RequestBody List<Product> dtos) throws IOException {
        List<ProductDTO> products = ProductDTO.mapearConverte(dtos);
        this.productService.createProduct(products);

        //this.productService.createProduct(products);
        return ResponseEntity.ok().build();

    }
    }

