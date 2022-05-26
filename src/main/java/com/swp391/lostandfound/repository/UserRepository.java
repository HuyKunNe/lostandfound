package com.swp391.lostandfound.repository;

import java.util.List;

import com.swp391.lostandfound.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findUserByStatus(int status);

    
    // @Modifying
    // @Query("update users s set s.status =?1 where s.id = ?2")
    // void updateStatusById(int status, int id);
}
