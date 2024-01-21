package com.example.springboot3jwtauthenticationserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


public class Pets {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
    private String breed;
    private String age;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="owner_id")
    @JsonIgnore
    private User owner;

}
