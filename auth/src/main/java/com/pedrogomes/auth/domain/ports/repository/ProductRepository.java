package com.pedrogomes.auth.domain.ports.repository;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.pedrogomes.auth.domain.models.ProductDTO;
import com.pedrogomes.auth.exceptions.ProductNotFoundException;

@Repository
public class ProductRepository {
private String messageProductNotFound = "Product not found.";

    public ProductDTO getProduct(String productName, Map<String, ProductDTO> products) {
        return Optional.ofNullable(products.get(productName))
            .orElseThrow(() -> new ProductNotFoundException(messageProductNotFound));
    }

    public void createProduct(ProductDTO productDTO, Map<String, ProductDTO> products){
        products.put(productDTO.productName(), productDTO);
    }
}
