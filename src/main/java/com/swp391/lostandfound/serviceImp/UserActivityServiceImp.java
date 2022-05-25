package com.swp391.lostandfound.serviceImp;

import java.util.List;

import com.swp391.lostandfound.entity.UserActivity;
import com.swp391.lostandfound.repository.UserActivityRepository;
import com.swp391.lostandfound.service.UserActivityService;

import org.springframework.stereotype.Service;

@Service
public class UserActivityServiceImp implements UserActivityService {

    private UserActivityRepository userActivityRepository;

    public UserActivityServiceImp(UserActivityRepository userActivityRepository) {
        this.userActivityRepository = userActivityRepository;
    }

    @Override
    public List<UserActivity> getAllUserActivity() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserActivity updateUserActivity(UserActivity activity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserActivity findUserActivityById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteUserActivityById(int id) {
        // TODO Auto-generated method stub
        return false;
    }

}
