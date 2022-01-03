package br.com.desafio.spring.g8.desafiospring.controller;

import br.com.desafio.spring.g8.desafiospring.dto.*;
import br.com.desafio.spring.g8.desafiospring.dto.TicketResponse;
import br.com.desafio.spring.g8.desafiospring.entity.Product;
import br.com.desafio.spring.g8.desafiospring.entity.Ticket;
import br.com.desafio.spring.g8.desafiospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/insert-articles-request")
    public ResponseEntity<ListProductsDTO> create(@RequestBody CreateProductsDTO createProductsDTO) throws IOException {
        List<Product> products = createProductsDTO.getArticles()
                .stream()
                .map(article -> article.toEntity())
                .collect(Collectors.toList());

        this.productService.createProduct(products);

        ListProductsDTO response = ListProductsDTO.builder()
                .articlesDTO(createProductsDTO.getArticles())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/articles")
    public ResponseEntity<List<Product>> findAllProductFilter(@RequestParam Map<String, String> allParams) throws IOException {
        return ResponseEntity.ok(this.productService.findFilter(allParams));
    }

    @PostMapping("/purchase-request")
    public ResponseEntity<TicketResponse> purchaseRequest(@RequestBody PurchaseDTO purchaseDTO) throws IOException {
        List<Product> products = purchaseDTO.getArticlesPurchaseRequest()
                .stream()
                .map(article -> article.toEntity())
                .collect(Collectors.toList());
        Ticket ticket = this.productService.purchaseRequest(products);
        TicketResponse.TicketDTO ticketDTO = new TicketResponse.TicketDTO(ticket.getId(), CompleteProductDTO.converte(ticket.getProducts()), ticket.getValorTotal());
        return ResponseEntity.ok(TicketResponse.builder().ticket(ticketDTO).build());
    }


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
//    }
}