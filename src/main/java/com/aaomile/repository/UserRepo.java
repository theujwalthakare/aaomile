package com.aaomile.repository;

import com.aaomile.entities.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    boolean existsByEmailAndPassword(String email, String password);
    //fucntion to check id emal is valid or not

    Optional<User> findByEmail(String username);

}
