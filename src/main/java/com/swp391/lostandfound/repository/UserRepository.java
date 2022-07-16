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
    @Query("update User set status = ?1 where id = ?2")
    void updateStatusById(Integer status, Integer id);

    @Modifying
    @Query("Select u from User u where u.email like ?1 and u.id != ?2")
    User existedEmailById(String email, int id);

    @Modifying
    @Query("Select u from User u where u.phoneNumber like ?1 and u.id != ?2")
    User existedPhoneNumberById(String phone, int id);

    @Modifying
    @Query("Select u from User u where u.studentCode like ?1 and u.id != ?2")
    User existedStudentCodeById(String email, int id);

    User findUserByStudentCodeAndPassword(String studentCode, String password);
}
