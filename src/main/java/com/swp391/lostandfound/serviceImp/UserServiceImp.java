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
    public List<User> getAllEnableUsers() {
        return userRepository.findUserByStatusAndRole(0, 2);
    }

    @Override
    public List<User> getAllAdmins() {
        return userRepository.findByRole(1);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findByRole(2);
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
        user.setPassword(userAddDTO.getPassword());
        user.setRole(2); // admin = 1, normal user = 2
        user.setStatus(0);
        user.setStudentCode(userAddDTO.getStudentCode().toUpperCase());
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
            user.setPassword(userUpdateDTO.getPassword());
            user.setStudentCode(userUpdateDTO.getStudentCode().toUpperCase());
            if (userRepository.findByIdNotLikeAndPhoneNumberLike(id, userUpdateDTO.getPhoneNumber()).isEmpty()
                    && userRepository.findByIdNotLikeAndStudentCodeLike(id, userUpdateDTO.getStudentCode()).isEmpty()
                    && userRepository.findByIdNotLikeAndEmailLike(id, userUpdateDTO.getEmail()).isEmpty()) {
                return userRepository.save(user);
            } else {
                return null;
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
            User user = userRepository.findById(id).get();
            if (user.getRole() == 2) {
                userRepository.updateStatusById(1, id);
                return true;
            } else {
                return false;
            }
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

    @Override
    public User findUserByStudentCodeandPassword(String studentCode, String password) {
        return userRepository.findUserByStudentCodeAndPassword(studentCode, password);
    }

    @Override
    public User setAdmin(int id) {
        if (userRepository.existsById(id)) {
            User user = userRepository.findById(id).get();
            if (user.getStatus() != 0) {
                return null;
            } else {
                user.setRole(1);
                userRepository.save(user);
                return user;
            }
        } else {
            return null;
        }
    }

}
