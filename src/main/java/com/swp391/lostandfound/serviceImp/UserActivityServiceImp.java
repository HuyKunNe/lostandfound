package com.swp391.lostandfound.serviceImp;

import java.util.List;

import com.swp391.lostandfound.DTO.UserActivityAddDTO;
import com.swp391.lostandfound.DTO.UserActivityUpdateDTO;
import com.swp391.lostandfound.entity.ChestItem;
import com.swp391.lostandfound.entity.UserActivity;
import com.swp391.lostandfound.repository.PostRepository;
import com.swp391.lostandfound.repository.UserActivityRepository;
import com.swp391.lostandfound.repository.UserRepository;
import com.swp391.lostandfound.service.UserActivityService;

import org.springframework.stereotype.Service;

@Service
public class UserActivityServiceImp implements UserActivityService {

    private UserActivityRepository userActivityRepository;
    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserActivityServiceImp(UserActivityRepository userActivityRepository, UserRepository userRepository, PostRepository postRepository) {
        this.userActivityRepository = userActivityRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<UserActivity> getAllUserActivity() {
        return userActivityRepository.findAll();
    }

    @Override
    public UserActivity updateUserActivity(UserActivity activity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserActivity findUserActivityById(int id) {
        if (userActivityRepository.existsById(id)) {
            return userActivityRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteUserActivityById(int id) {
        if (userActivityRepository.existsById(id)) {
            userActivityRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserActivity addUserActivity(UserActivityAddDTO userActivityAddDTO) {
        var userActivity = new UserActivity();
        userActivity.setDate(userActivityAddDTO.getDate());
        userActivity.setType(userActivityAddDTO.getType());
        if (userRepository.existsById(userActivityAddDTO.getUserId())) {
            userActivity.setUser(userRepository.findById(userActivityAddDTO.getUserId()).get());
            if (postRepository.existsById(userActivityAddDTO.getPostId())) {
                userActivity.setPost(postRepository.findById(userActivityAddDTO.getPostId()).get());
                return userActivityRepository.save(userActivity);
            } else {
                return null;
            }
        } else
            return null;
    }

    @Override
    public UserActivity updateUserActivity(int id, UserActivityUpdateDTO userActivityUpdateDTO) {
        if (userActivityRepository.existsById(id)) {
            var userActivity = userActivityRepository.findById(id).get();
            userActivity.setDate(userActivityUpdateDTO.getDate());
            userActivity.setType(userActivityUpdateDTO.getType());
            if (userRepository.existsById(userActivityUpdateDTO.getUserId())) {
                userActivity.setUser(userRepository.findById(userActivityUpdateDTO.getUserId()).get());
                if (postRepository.existsById(userActivityUpdateDTO.getPostId())) {
                    userActivity.setPost(postRepository.findById(userActivityUpdateDTO.getPostId()).get());
                    return userActivityRepository.save(userActivity);
                } else {
                    return null;
                }
            } else
                return null;
        } else {
            return null;
        }
    }

}
