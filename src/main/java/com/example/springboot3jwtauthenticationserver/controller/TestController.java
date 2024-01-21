package com.example.springboot3jwtauthenticationserver.controller;

import com.example.springboot3jwtauthenticationserver.repositories.UserRepository;
import com.example.springboot3jwtauthenticationserver.services.JwtService;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/test")

public class TestController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/anon")
    public String anonEndPoint() {
        return "everyone can see this";
    }


    @GetMapping("/users")
    @PreAuthorize("hasRole('ROLE_USER')")
    @Transactional
    public String usersEndPoint() {
        return "ONLY users can see this";
    }

    @GetMapping("/admins")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminsEndPoint() {
        return "ONLY admins can see this";
    }

    @GetMapping("/mypets")
    public ResponseEntity<List> protectedEndpoint(Authentication authentication) {

        return ResponseEntity.ok(userRepository.getPetsByAuthenticatedUser(authentication.getName()));


    }
}
