package com.pedrogomes.auth.domain.ports;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.pedrogomes.auth.domain.models.User;

@Repository
public interface UserPort {
    UserDetails findByUserName(String username); 
    void register(User user, Map<String, User> users);
}
