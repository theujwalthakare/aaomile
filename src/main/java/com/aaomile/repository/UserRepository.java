package com.aaomile.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaomile.entities.Login;

public interface UserRepository extends JpaRepository<Login, String> {
    Optional<Login> findByIdAndPassword(String id, String password);
}