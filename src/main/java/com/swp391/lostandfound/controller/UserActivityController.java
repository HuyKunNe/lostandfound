package com.swp391.lostandfound.controller;

import com.swp391.lostandfound.service.UserActivityService;

import org.springframework.stereotype.Controller;

@Controller
public class UserActivityController {

    private UserActivityService userActivityService;

    public UserActivityController(UserActivityService userActivityService) {
        this.userActivityService = userActivityService;
    }

}
