package com.swp391.lostandfound.repository;

import com.swp391.lostandfound.entity.ChestItem;
import com.swp391.lostandfound.entity.UserActivity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserActivityRepository extends JpaRepository<UserActivity, Integer> {

}
