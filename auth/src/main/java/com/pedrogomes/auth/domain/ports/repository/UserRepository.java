package com.pedrogomes.auth.domain.ports.repository;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.pedrogomes.auth.AuthApplication;
import com.pedrogomes.auth.domain.models.User;
import com.pedrogomes.auth.domain.ports.UserPort;
import com.pedrogomes.auth.exceptions.UserNotFoundException;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserRepository implements UserPort {

    private String messageUserNotFound = "User not found.";

    @Override
    public UserDetails findByUserName(String username) {
        return Optional.ofNullable(AuthApplication.users.get(username))
            .orElseThrow(() -> new UserNotFoundException(messageUserNotFound));
    }

    @Override
    public void register(User user, Map<String, User> users) {
        users.put(user.getUsername(), user);
    }
}
