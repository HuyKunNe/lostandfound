package com.swp391.lostandfound.service;

import java.util.List;

import com.swp391.lostandfound.entity.User;

public interface UserService {
    List<User> getAllUsers();

    User addUser(User user);

    User updateUser(User user);

    User findUserById(int id);

    boolean deleteUserById(int id);
}
