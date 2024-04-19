package com.pedrogomes.auth.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {
    public String getProduct(){
        return "{\"response\": \"Sucesso\"}";
    }
}
