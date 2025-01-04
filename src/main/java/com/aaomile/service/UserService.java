package com.aaomile.service;

import org.springframework.stereotype.Service;

import com.aaomile.entities.User;


@Service
public interface UserService {

    User createUser(User user); //to insert vales in user table

    boolean existsByEmailAndPassword(String email, String password);  // to check the email and password for login

}
