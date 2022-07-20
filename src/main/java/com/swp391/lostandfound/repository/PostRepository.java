package com.swp391.lostandfound.repository;

import java.util.List;

import com.swp391.lostandfound.entity.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findPostByStatus(int status);

    List<Post> findPostByStatusLessThan(int status);

    List<Post> findPostByTypeAndStatus(int type, int status);


    @Modifying
    @Query("update Post set Status = ?1 where Id = ?2")
    void UpdateStatusById(int status, int id);

    @Modifying
    @Query("update Post set CreateUserId = ?1 where Id = ?2")
    boolean updateCreateUserIdById(int createUserId, int id);

    @Modifying
    @Query("update Post set CreateUserId = ?1 where Id = ?2")
    boolean updateReturnUserIdById(int returnUserId, int id);

}
