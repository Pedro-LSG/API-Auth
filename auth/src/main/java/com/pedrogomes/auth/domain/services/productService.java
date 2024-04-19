package com.pedrogomes.auth.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrogomes.auth.domain.ports.ProductPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {
    private final ProductPort productPort;

    public String getProduct(){
        return productPort.getProduct();
    }
}
