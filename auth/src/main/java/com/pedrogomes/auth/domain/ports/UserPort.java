package com.pedrogomes.auth.domain.ports;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPort {
    UserDetails findByUserName(String username); 
}
