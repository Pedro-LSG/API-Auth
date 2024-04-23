package com.pedrogomes.auth.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrogomes.auth.domain.models.Product;
import com.pedrogomes.auth.domain.services.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {
    private final ProductService productService;
    Map<String, Product> products = new HashMap<>();

    @GetMapping("{productName}")
    public ResponseEntity<Product> GetProduct(@PathVariable String productName){
        Product productResponse = productService.getProduct(productName, products);

        return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(productResponse);
    }   
    
    @PostMapping
    public ResponseEntity<String> CreateProduct(@RequestBody Product productDTO){
        productService.createUser(productDTO, products);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}