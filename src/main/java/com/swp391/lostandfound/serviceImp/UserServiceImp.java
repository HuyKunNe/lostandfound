package com.swp391.lostandfound.serviceImp;

import java.util.List;

import com.swp391.lostandfound.entity.User;
import com.swp391.lostandfound.repository.UserRepository;
import com.swp391.lostandfound.service.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User addUser(User user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User updateUser(User user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findUserById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteUserById(int id) {
        // TODO Auto-generated method stub
        return false;
    }

}
