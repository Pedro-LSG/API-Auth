package com.pedrogomes.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pedrogomes.auth.domain.models.User;
import com.pedrogomes.auth.domain.models.UserRole;

@SpringBootApplication
public class AuthApplication {
	public static Map<String, User> users = new HashMap<>();
	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
		users.put("pedrogomes", new User("pedrogomes", 
											new BCryptPasswordEncoder().encode("123456"), 
											UserRole.ADMIN));
	}

}
