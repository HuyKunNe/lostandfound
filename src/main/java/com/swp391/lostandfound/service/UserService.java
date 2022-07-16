package com.swp391.lostandfound.service;

import java.util.List;

import com.swp391.lostandfound.DTO.UserAddDTO;
import com.swp391.lostandfound.DTO.UserUpdateDTO;
import com.swp391.lostandfound.entity.User;

public interface UserService {
    List<User> getAllUsers();

    User addUser(UserAddDTO userAddDTO);

    User updateUser(int id, UserUpdateDTO updateDTO);

    User findUserById(int id);

    User findUserByPhone(String phoneNumber);

    User findUserByEmail(String email);

    User findUserByStudentCode(String studentCode);

    boolean deleteUserById(int id);

    User findUserByStudentCodeandPassword(String studentCode, String password);
}
