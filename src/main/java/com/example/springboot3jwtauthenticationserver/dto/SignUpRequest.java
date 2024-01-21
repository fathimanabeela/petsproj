package com.example.springboot3jwtauthenticationserver.dto;

import com.example.springboot3jwtauthenticationserver.models.Pets;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    String firstName;
    String lastName;
    String email;
    String password;
    List<Pets> pets;
}
