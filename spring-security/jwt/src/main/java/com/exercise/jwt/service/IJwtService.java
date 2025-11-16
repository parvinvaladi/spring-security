package com.exercise.jwt.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {

    String generateToken(String userName);

    String extractUserName(String token);

    boolean validateToken(String token, UserDetails userDetails);

}
