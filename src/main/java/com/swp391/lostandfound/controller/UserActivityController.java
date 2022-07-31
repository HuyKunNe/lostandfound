package com.swp391.lostandfound.controller;

import com.swp391.lostandfound.DTO.UserActivityUpdateDTO;
import com.swp391.lostandfound.dataFormat.ListUserActivity;
import com.swp391.lostandfound.dataFormat.UserActivityData;
import com.swp391.lostandfound.service.UserActivityService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin("*")
public class UserActivityController {

    private UserActivityService userActivityService;

    public UserActivityController(UserActivityService userActivityService) {
        this.userActivityService = userActivityService;
    }

    @GetMapping("/userActivity")
    public ListUserActivity getUserActivates() {
        var list = new ListUserActivity();
        list.setData(userActivityService.getAllUserActivity());
        if (list.getData().isEmpty()) {
            list.setMessage("List is Empty");
            list.setStatus("Success");
        } else {
            list.setMessage("Get all user activity Successfully");
            list.setStatus("Success");
        }
        return list;
    }

    @GetMapping("/userActivity/{id}")
    public UserActivityData findUserActivityById(@PathVariable int id) {
        var userActivityData = new UserActivityData();
        userActivityData.setUserActivity(userActivityService.findUserActivityById(id));
        if (userActivityData.getUserActivity() != null) {
            userActivityData.setMessage("Find user activity successfully");
            userActivityData.setStatus("Success");
        } else {
            userActivityData.setMessage("User activity does not exist");
            userActivityData.setStatus("Fail");
        }
        return userActivityData;
    }

    @PutMapping("/userActivity/edit/{id}")
    public UserActivityData updateUserActivity(@PathVariable int id,@RequestBody  UserActivityUpdateDTO userActivityUpdateDTO) {
        var userActivityData = new UserActivityData();
        userActivityData.setUserActivity(userActivityService.updateUserActivity(id, userActivityUpdateDTO));
        if (userActivityData.getUserActivity() != null) {
            userActivityData.setMessage("Update user activity successfully");
            userActivityData.setStatus("Success");
        } else {
            userActivityData.setMessage("Update user activity Fail");
            userActivityData.setStatus("Fail");
        }
        return userActivityData;
    }

    @DeleteMapping("/userActivity/{id}")
    public UserActivityData deleteUserActivityById(@PathVariable int id) {
        var chestItemData = new UserActivityData();
        if (userActivityService.deleteUserActivityById(id)) {
            chestItemData.setMessage("Delete user activity successfully");
            chestItemData.setStatus("Success");
        } else {
            chestItemData.setMessage("Delete user activity Fail");
            chestItemData.setStatus("Fail");
        }
        return chestItemData;
    }

}
