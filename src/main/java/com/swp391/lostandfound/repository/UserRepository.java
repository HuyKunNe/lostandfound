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

    User findByEmailLike(String email);

    User findByPhoneNumberLike(String phoneNumber);

    User findByStudentCodeLike(String StudentCode);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByStudentCode(String StudentCode);

    @Modifying
    @Query("update User set Status = ?1 where Id = ?2")
    void updateStatusById(Integer status, Integer id);

}
