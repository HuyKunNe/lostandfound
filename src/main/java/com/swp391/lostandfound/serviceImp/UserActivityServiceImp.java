package com.swp391.lostandfound.serviceImp;

import java.util.List;

import com.swp391.lostandfound.DTO.UserActivityUpdateDTO;
import com.swp391.lostandfound.entity.UserActivity;
import com.swp391.lostandfound.repository.PostRepository;
import com.swp391.lostandfound.repository.UserActivityRepository;
import com.swp391.lostandfound.repository.UserRepository;
import com.swp391.lostandfound.service.UserActivityService;

import org.springframework.stereotype.Service;

@Service
public class UserActivityServiceImp implements UserActivityService {

    // type = 0 create Post
    // Type = 1 bring items to AdminRoom
    // type = 2 receive item from AdminRoom

    private UserActivityRepository userActivityRepository;
    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserActivityServiceImp(UserActivityRepository userActivityRepository, UserRepository userRepository,
            PostRepository postRepository) {
        this.userActivityRepository = userActivityRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<UserActivity> getAllUserActivity() {
        return userActivityRepository.findByStatus(0);
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
            userActivityRepository.setFixedStatusFor(1, id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserActivity updateUserActivity(int id, UserActivityUpdateDTO userActivityUpdateDTO) {
        if (userActivityRepository.existsById(id)) {
            var userActivity = userActivityRepository.findById(id).get();
            userActivity.setDate(userActivityUpdateDTO.getDate());
            userActivity.setType(userActivityUpdateDTO.getType());
            userActivity.setStatus(userActivityUpdateDTO.getStatus());
            if (userRepository.existsById(userActivityUpdateDTO.getUserId())) {
                userActivity.setUser(userRepository.findById(userActivityUpdateDTO.getUserId()));
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
