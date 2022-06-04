package com.swp391.lostandfound.service;

import java.util.List;

import com.swp391.lostandfound.DTO.UserActivityAddDTO;
import com.swp391.lostandfound.DTO.UserActivityUpdateDTO;
import com.swp391.lostandfound.entity.UserActivity;

public interface UserActivityService {
    List<UserActivity> getAllUserActivity();

    UserActivity updateUserActivity(UserActivity activity);

    UserActivity findUserActivityById(int id);

    boolean deleteUserActivityById(int id);

    UserActivity addUserActivity(UserActivityAddDTO userActivityAddDTO);

    UserActivity updateUserActivity(int id, UserActivityUpdateDTO userActivityUpdateDTO);
}
