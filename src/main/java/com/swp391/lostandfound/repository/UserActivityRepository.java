package com.swp391.lostandfound.repository;

import com.swp391.lostandfound.entity.UserActivity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserActivityRepository extends JpaRepository<UserActivity, Integer> {
    List<UserActivity> findByStatus(int status);

    @Modifying
    @Query("update UserActivity set status=?1 where id = ?2")
    UserActivity setFixedStatusFor(int status, int id);
}
