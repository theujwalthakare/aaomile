package com.aaomile.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aaomile.entities.User;


@Service
public interface UserService {

    User createUser(User user);

    // Optional<User> getUserByEmailandPassword(String email, String password);
    boolean existsByEmailAndPassword(String email, String password);

}
