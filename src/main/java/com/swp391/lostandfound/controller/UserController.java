package com.swp391.lostandfound.controller;

import com.swp391.lostandfound.DTO.UserAddDTO;
import com.swp391.lostandfound.DTO.UserUpdateDTO;
import com.swp391.lostandfound.dataFormat.ListUsersData;
import com.swp391.lostandfound.dataFormat.UserData;
import com.swp391.lostandfound.entity.User;
import com.swp391.lostandfound.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@CrossOrigin("*")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user-enable")
    public ListUsersData getAllEnableUsers() {
        ListUsersData users = new ListUsersData();
        users.setData(userService.getAllEnableUsers());
        if (userService.getAllEnableUsers().isEmpty()) {
            users.setMessage("List is empty");
        } else
            users.setMessage("get all enable users successfully");
        users.setStatus("success");
        return users;
    }

    @GetMapping("/user")
    public ListUsersData getAllUsers() {
        ListUsersData users = new ListUsersData();
        users.setData(userService.getAllUsers());
        if (userService.getAllUsers().isEmpty()) {
            users.setMessage("List is empty");
        } else
            users.setMessage("get all enable users successfully");
        users.setStatus("success");
        return users;
    }

    @GetMapping("/admin")
    public ListUsersData getAllAdmins() {
        ListUsersData users = new ListUsersData();
        users.setData(userService.getAllAdmins());
        if (userService.getAllAdmins().isEmpty()) {
            users.setMessage("List is empty");
        } else
            users.setMessage("get all enable users successfully");
        users.setStatus("success");
        return users;
    }

    @GetMapping("/user/{id}")
    public UserData getUserById(@PathVariable int id) {
        UserData userData = new UserData();
        User user = userService.findUserById(id);
        if (user != null) {
            userData.setMessage("Find User Successfully");
            userData.setUser(user);
            userData.setStatus("Success");
        } else {
            userData.setMessage("User is not exist");
            userData.setStatus("Fail");
        }
        return userData;
    }

    @PutMapping("/user/edit/{id}")
    public UserData updateUser(@PathVariable int id, UserUpdateDTO updateDTO) {
        UserData userData = new UserData();
        User user = userService.updateUser(id, updateDTO);
        if (user != null) {
            userData.setMessage("Update User Successfully");
            userData.setUser(user);
            userData.setStatus("Success");
        } else {
            userData.setMessage("Update failed");
            userData.setStatus("Fail");
        }
        return userData;
    }

    @PostMapping("/user")
    public UserData createUser(UserAddDTO userAddDTO) {
        UserData userData = new UserData();
        User user = userService.addUser(userAddDTO);
        if (user != null) {
            userData.setMessage("Create User Successfully");
            userData.setUser(user);
            userData.setStatus("Success");
        } else {
            userData.setMessage("Create User Failed");
            userData.setStatus("Fail");
        }

        return userData;
    }

    @DeleteMapping("/user/{id}")
    public UserData deleteUserById(@PathVariable int id) {
        UserData userData = new UserData();
        if (userService.deleteUserById(id)) {
            userData.setMessage("Delete User Successfully");
            userData.setStatus("Success");
        } else {
            userData.setMessage("Delete User Failure");
            userData.setStatus("Fail");
        }

        return userData;
    }

    @GetMapping("/user/findByPhone")
    public UserData findUserByPhone(String phoneNumber) {
        UserData userData = new UserData();
        User user = userService.findUserByPhone(phoneNumber);
        if (user != null) {
            userData.setMessage("Find User successfully");
            userData.setUser(user);
            userData.setStatus("Success");
        } else {
            userData.setMessage("User is not exist");
            userData.setStatus("Fail");
        }
        return userData;
    }

    @GetMapping("/user/findByEmail")
    public UserData findUserByEmail(String email) {
        UserData userData = new UserData();
        User user = userService.findUserByEmail(email);
        if (user != null) {
            userData.setMessage("Find User successfully");
            userData.setUser(user);
            userData.setStatus("Success");
        } else {
            userData.setMessage("User is not exist");
            userData.setStatus("Fail");
        }
        return userData;
    }

    @GetMapping("/user/findByStudentCode")
    public UserData findUserByStudentCode(String studentCode) {
        UserData userData = new UserData();
        User user = userService.findUserByStudentCode(studentCode);
        if (user != null) {
            userData.setMessage("Find User successfully");
            userData.setUser(user);
            userData.setStatus("Success");
        } else {
            userData.setMessage("User is not exist");
            userData.setStatus("Fail");
        }
        return userData;
    }

    @GetMapping("/login")
    public UserData Login(String studentCode, String password) {
        UserData userData = new UserData();
        User user = userService.findUserByStudentCodeandPassword(studentCode.toUpperCase(), password);
        if (user != null) {
            userData.setMessage("Login successfully");
            userData.setUser(user);
            userData.setStatus("Success");
        } else {
            userData.setMessage("User is not exist");
            userData.setStatus("Fail");
        }
        return userData;
    }

    @PutMapping("/user/setAdmin")
    public UserData setAdmin(int id) {
        UserData userData = new UserData();
        User user = userService.setAdmin(id);
        if (user != null) {
            userData.setMessage("Set admin successfully");
            userData.setUser(user);
            userData.setStatus("Success");
        } else {
            userData.setMessage("Set admin failed");
            userData.setStatus("Fail");
        }
        return userData;
    }
}