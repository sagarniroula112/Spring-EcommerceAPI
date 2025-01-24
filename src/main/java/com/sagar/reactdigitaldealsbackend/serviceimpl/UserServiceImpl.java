package com.sagar.reactdigitaldealsbackend.serviceimpl;

import com.sagar.reactdigitaldealsbackend.model.User;
import com.sagar.reactdigitaldealsbackend.repository.UserRepo;
import com.sagar.reactdigitaldealsbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public void addUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public User getUserById(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
