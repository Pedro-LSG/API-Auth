package com.pedrogomes.auth.domain.ports.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.pedrogomes.auth.domain.models.User;
import com.pedrogomes.auth.domain.models.UserRole;
import com.pedrogomes.auth.domain.ports.UserPort;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserRepository implements UserPort {
    @Override
    public UserDetails findByUserName(String username) {
        return new User("pedrogomes", "123456", UserRole.ADMIN);
    }
}
