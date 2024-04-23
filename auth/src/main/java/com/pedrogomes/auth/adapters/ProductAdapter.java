package com.pedrogomes.auth.adapters;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pedrogomes.auth.domain.models.Product;
import com.pedrogomes.auth.domain.ports.ProductPort;
import com.pedrogomes.auth.domain.ports.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductAdapter implements ProductPort {
    private final ProductRepository productRepository;

    @Override
    public Product getProduct(String productName, Map<String, Product> products){
        return productRepository.getProduct(productName, products);
    }

    @Override
    public void createProduct(Product productDTO, Map<String, Product> products) {
        productRepository.createProduct(productDTO, products);
    }
}
