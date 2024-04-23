package com.pedrogomes.auth.domain.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrogomes.auth.domain.models.Product;
import com.pedrogomes.auth.domain.ports.ProductPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {
    private final ProductPort productPort;

    public Product getProduct(String productName, Map<String, Product> products){
        return productPort.getProduct(productName, products);
    }

    public void createUser(Product productDTO, Map<String, Product> products){
        productPort.createProduct(productDTO, products);
    }
}
