package com.exercise.jwt.service;


import com.exercise.jwt.dao.UserRepo;
import com.exercise.jwt.model.User;
import com.exercise.jwt.model.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepo.findByUserName(username);
        if (userOptional.isEmpty()){
            throw new UsernameNotFoundException("this userName not found");
        }

        return new UserPrincipal(userOptional.get());
    }
}
