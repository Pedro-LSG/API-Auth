package com.pedrogomes.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrogomes.auth.domain.models.Authentication;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {
private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Authentication credentials){
        var usernamePassword = new UsernamePasswordAuthenticationToken(credentials.username(), credentials.password());
        this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
