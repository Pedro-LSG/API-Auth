package com.pedrogomes.auth.domain.ports.repository;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.pedrogomes.auth.domain.models.Product;
import com.pedrogomes.auth.exceptions.ProductNotFoundException;

@Repository
public class ProductRepository {
private String messageProductNotFound = "Product not found.";

    public Product getProduct(String productName, Map<String, Product> products) {
        return Optional.ofNullable(products.get(productName))
            .orElseThrow(() -> new ProductNotFoundException(messageProductNotFound));
    }

    public void createProduct(Product productDTO, Map<String, Product> products){
        products.put(productDTO.productName(), productDTO);
    }
}
