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

    List<User> findUserByStatusAndRole(int status, int role);

    List<User> findByRole(int role);

    User findByEmailLike(String email);

    User findByPhoneNumberLike(String phoneNumber);

    User findByStudentCodeLike(String StudentCode);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByStudentCode(String StudentCode);

    List<User> findByIdNotLikeAndStudentCodeLike(int id, String StudentCode);

    List<User> findByIdNotLikeAndPhoneNumberLike(int id, String StudentCode);

    List<User> findByIdNotLikeAndEmailLike(int id, String StudentCode);

    @Modifying
    @Query("update User set status = ?1 where id = ?2")
    void updateStatusById(Integer status, Integer id);

    User findUserByStudentCodeAndPassword(String studentCode, String password);
}
