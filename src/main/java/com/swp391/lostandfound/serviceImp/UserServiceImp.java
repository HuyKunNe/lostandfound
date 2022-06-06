package com.swp391.lostandfound.serviceImp;

import java.util.List;

import com.swp391.lostandfound.DTO.UserAddDTO;
import com.swp391.lostandfound.DTO.UserUpdateDTO;
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
        return userRepository.findUserByStatus(0);
    }

    @Override
    public User addUser(UserAddDTO userAddDTO) {
        User user = new User();
        user.setFirstName(userAddDTO.getFirstName());
        user.setLastName(userAddDTO.getLastName());
        user.setEmail(userAddDTO.getEmail());
        user.setGender(userAddDTO.getGender());
        user.setPhoneNumber(userAddDTO.getPhoneNumber());
        user.setBirthday(userAddDTO.getBirthday());
        user.setRole(2); // admin = 1, normal user = 2
        user.setStatus(0);
        user.setStudentCode(userAddDTO.getStudentCode());
        if (userRepository.existsByPhoneNumber(userAddDTO.getPhoneNumber())
                || userRepository.existsByStudentCode(userAddDTO.getStudentCode())
                || userRepository.existsByEmail(userAddDTO.getEmail())) {
            return null;
        } else {
            return userRepository.save(user);
        }
    }

    @Override
    public User updateUser(int id, UserUpdateDTO userUpdateDTO) {
        if (userRepository.existsById(id)) {
            User user = userRepository.findById(id).get();
            user.setBirthday(userUpdateDTO.getBirthday());
            user.setEmail(userUpdateDTO.getEmail());
            user.setFirstName(userUpdateDTO.getFirstName());
            user.setLastName(userUpdateDTO.getLastName());
            user.setGender(userUpdateDTO.getGender());
            user.setPhoneNumber(userUpdateDTO.getPhoneNumber());
            user.setStatus(userUpdateDTO.getStatus());
            user.setStudentCode(userUpdateDTO.getStudentCode());
            if (userRepository.existedPhoneById(userUpdateDTO.getPhoneNumber(), id) != null
                    || userRepository.existedStudentCodeById(userUpdateDTO.getStudentCode(), id) != null
                    || userRepository.existedEmailById(userUpdateDTO.getEmail(), id) != null) {
                return null;
            } else {
                return userRepository.save(user);
            }
        } else
            return null;
    }

    @Override
    public User findUserById(int id) {
        if (userRepository.existsById(id)) {
            return userRepository.findById(id).get();
        } else
            return null;
    }

    @Override
    public boolean deleteUserById(int id) {
        if (userRepository.existsById(id)) {
            userRepository.updateStatusById(1, id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User findUserByPhone(String phoneNumber) {
        return userRepository.findByPhoneNumberLike(phoneNumber);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmailLike(email);
    }

    @Override
    public User findUserByStudentCode(String studentCode) {
        return userRepository.findByStudentCodeLike(studentCode);
    }

}
