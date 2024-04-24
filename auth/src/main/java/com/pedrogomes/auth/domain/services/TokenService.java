package com.pedrogomes.auth.domain.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.pedrogomes.auth.domain.models.User;
import com.pedrogomes.auth.exceptions.GeneratingTokenException;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    private String errorGeneratingToken = "Error while generating token";
    private String brasiliaTimeZone = "-03:00";

    public String generateToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create().withIssuer("auth-api").withSubject(user.getUsername()).withExpiresAt(generateExpirationDate()).sign(algorithm);
            return token;
        }
        catch(JWTCreationException exception){
            throw new GeneratingTokenException(errorGeneratingToken);
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm).withIssuer("auth-api").build().verify(token).getSubject();
        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    private Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of(brasiliaTimeZone));
    }
}