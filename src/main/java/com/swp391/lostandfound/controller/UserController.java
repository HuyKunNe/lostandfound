package com.swp391.lostandfound.controller;

import com.swp391.lostandfound.service.UserService;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

}
