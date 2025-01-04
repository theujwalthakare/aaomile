package com.aaomile.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaomile.entities.User;
import com.aaomile.repository.UserRepo;
import com.aaomile.service.UserService;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public boolean existsByEmailAndPassword(String email, String password) {
        return userRepo.existsByEmailAndPassword(email, password);
    }

    
    // @Override
    // public Optional<User> getUserByEmailandPassword(String email, String password) {
    //     return userRepo.findByEmailAndPassword(email,password);
    // }
    
    

}
