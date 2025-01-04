package com.aaomile.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaomile.entities.Login;
public interface LoginRepository extends JpaRepository<Login, String> {

    Optional<Login> findByIdAndPassword(String id, String password);
    // Optional<User> findByIdAndPassword(String firstname, String lastname, String email, String password);
}