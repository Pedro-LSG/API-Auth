package com.pedrogomes.auth.adapters;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pedrogomes.auth.domain.models.ProductDTO;
import com.pedrogomes.auth.domain.ports.ProductPort;
import com.pedrogomes.auth.domain.ports.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductAdapter implements ProductPort {
    private final ProductRepository productRepository;

    @Override
    public ProductDTO getProduct(String productName, Map<String, ProductDTO> products){
        return productRepository.getProduct(productName, products);
    }

    @Override
    public void createProduct(ProductDTO productDTO, Map<String, ProductDTO> products) {
        productRepository.createProduct(productDTO, products);
    }
}
