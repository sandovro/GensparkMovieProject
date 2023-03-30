package com.example.movieProject.Service;

import com.example.movieProject.Entity.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User getUser(User user);
    User getUserByEmail(String userEmail);
    User addUser(User user);
    User updateUser(User user);
    String deleteUser(String userEmail);
}
