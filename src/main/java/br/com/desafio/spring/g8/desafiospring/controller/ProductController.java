package br.com.desafio.spring.g8.desafiospring.controller;

import br.com.desafio.spring.g8.desafiospring.entity.Product;
import br.com.desafio.spring.g8.desafiospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


//Product Controller - essa classe corresponde ao C do modelo MVC - Wolsen

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


    }
}
