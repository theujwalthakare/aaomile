package com.aaomile.repository;

import com.aaomile.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    boolean existsByEmailAndPassword(String email, String password);

    //fucntion to check id emal is valid or not
}
