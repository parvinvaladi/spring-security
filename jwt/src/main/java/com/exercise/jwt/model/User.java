package com.exercise.jwt.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;
}
