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

import com.pedrogomes.auth.AuthApplication;
import com.pedrogomes.auth.domain.models.Authentication;
import com.pedrogomes.auth.domain.models.LoginResponse;
import com.pedrogomes.auth.domain.models.User;
import com.pedrogomes.auth.domain.ports.UserPort;
import com.pedrogomes.auth.domain.services.TokenService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserPort userPort;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody Authentication credentials) throws Exception{
        var usernamePassword = new UsernamePasswordAuthenticationToken(credentials.username(), credentials.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User)auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User register){
        userPort.register(register, AuthApplication.users);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
