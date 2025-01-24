package com.sagar.reactdigitaldealsbackend.repository;

import com.sagar.reactdigitaldealsbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);
}
