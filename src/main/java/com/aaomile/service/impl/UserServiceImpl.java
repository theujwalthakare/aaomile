package com.aaomile.service.impl;


// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aaomile.entities.User;
import com.aaomile.repository.UserRepo;
import com.aaomile.service.UserService;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    
    @Override
    public User createUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //set the user role
        // user.setRoleList(List.of(AppConstansts.ROLE_USER));
        return userRepo.save(user);
    }

    @Override
    public boolean existsByEmailAndPassword(String email, String password) {
        return userRepo.existsByEmailAndPassword(email, password);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email).orElse(null);
    }

    @Override
    public User getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User getUserByName(String name) {
        return userRepo.findByFullName(name);
    }


}
