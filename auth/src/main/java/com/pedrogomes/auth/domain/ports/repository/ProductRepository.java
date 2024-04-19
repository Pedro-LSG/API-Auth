package com.pedrogomes.auth.domain.ports.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    public String getProduct() {
        return "{\"response\": \"Sucesso\"}";
    }
    
}
