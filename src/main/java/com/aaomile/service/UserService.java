package com.aaomile.service;

import org.springframework.stereotype.Service;

import com.aaomile.entities.User;

@Service
public interface UserService {

    User createUser(User user);

}
