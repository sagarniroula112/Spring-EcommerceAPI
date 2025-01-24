package com.sagar.reactdigitaldealsbackend.service;

import com.sagar.reactdigitaldealsbackend.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
    User getUserByUsernameAndPassword(String username, String password);
    List<User> getAllUsers();
}
