package com.pedrogomes.auth.domain.ports;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductPort {
    String getProduct();
}
