package com.pedrogomes.auth.domain.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User implements UserDetails {
    String userName;
    String password;
    UserRole userRole;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(userRole == UserRole.ADMIN) 
            return List.of(new SimpleGrantedAuthority(UserRole.ROLE_ADMIN.getRole()), new SimpleGrantedAuthority(UserRole.ROLE_USER.getRole()));

        return List.of(new SimpleGrantedAuthority(UserRole.ROLE_USER.getRole()));
    }

    @Override
    public String getPassword() { return password; }

    @Override
    public String getUsername() { return userName; }

    @Override
    public boolean isAccountNonExpired() { return true;}

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

}
