package com.aaomile.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

// import com.aaomile.entities.Login;
import com.aaomile.entities.User;

// public interface LoginRepository extends JpaRepository<Login, String> {

//     Optional<Login> findByIdAndPassword(String id, String password);
//     // Optional<User> findByIdAndPassword(String firstname, String lastname, String email, String password);
// }
public interface LoginRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmailAndPassword(String email, String password);
}