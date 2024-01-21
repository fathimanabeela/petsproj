package com.example.springboot3jwtauthenticationserver.config;

import com.example.springboot3jwtauthenticationserver.models.Role;
import com.example.springboot3jwtauthenticationserver.repositories.UserRepository;
import com.example.springboot3jwtauthenticationserver.services.UserService;
import com.example.springboot3jwtauthenticationserver.models.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

@Component
@RequiredArgsConstructor
@Slf4j

public class SeedDataConfig implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;


    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() == 0) {

            User admin = User
                    .builder()
                    .firstName("admin")
                    .lastName("admin")
                    .email("admin@admin.com")
                    .password(passwordEncoder.encode("password"))
                    .role(Role.ROLE_ADMIN)
                    .build();

            userService.save(admin);
            System.out.println("created ADMIN user - {}"+ admin);
        }
    }
}
