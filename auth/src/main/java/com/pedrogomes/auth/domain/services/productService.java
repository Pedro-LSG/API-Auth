package com.pedrogomes.auth.domain.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrogomes.auth.domain.models.ProductDTO;
import com.pedrogomes.auth.domain.ports.ProductPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {
    private final ProductPort productPort;

    public ProductDTO getProduct(String productName, Map<String, ProductDTO> products){
        return productPort.getProduct(productName, products);
    }

    public void createUser(ProductDTO productDTO, Map<String, ProductDTO> products){
        productPort.createProduct(productDTO, products);
    }
}
