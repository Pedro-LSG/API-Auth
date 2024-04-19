package com.pedrogomes.auth.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pedrogomes.auth.domain.ports.ProductPort;
import com.pedrogomes.auth.domain.ports.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductAdapter implements ProductPort {
    private final ProductRepository productRepository;

    public String getProduct(){
        return productRepository.getProduct();
    }
}
