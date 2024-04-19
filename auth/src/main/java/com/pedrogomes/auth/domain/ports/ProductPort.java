package com.pedrogomes.auth.domain.ports;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pedrogomes.auth.domain.models.ProductDTO;

@Repository
public interface ProductPort {
    ProductDTO getProduct(String productName, Map<String, ProductDTO> products);
    void createProduct(ProductDTO productDTO, Map<String, ProductDTO> products);
}
