package com.pedrogomes.auth.domain.models;

public enum UserRole {
    ADMIN("ADMIN"),
    USER("USER"),
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
