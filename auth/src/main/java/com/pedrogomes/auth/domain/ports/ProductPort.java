package com.pedrogomes.auth.domain.ports;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pedrogomes.auth.domain.models.Product;

@Repository
public interface ProductPort {
    Product getProduct(String productName, Map<String, Product> products);
    void createProduct(Product productDTO, Map<String, Product> products);
}
