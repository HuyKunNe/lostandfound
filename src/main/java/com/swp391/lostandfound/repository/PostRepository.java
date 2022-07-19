package com.swp391.lostandfound.repository;

import java.util.List;

import com.swp391.lostandfound.DTO.responseDTO.IPostReponseDTO;
import com.swp391.lostandfound.DTO.responseDTO.PostResponseDTO;
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

    List<Post> findPostByType(int type);

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

    public final static String GET_ALL_POST_WITH_MEDIA = "select p.id, p.description, p.location, p.status, p.type, p.create_user_id, p.return_user_id, p.name, m.postid from post p, media m"
            + " where p.id in (select distinct m.postid from media)"
            + "group by p.id, p.description, p.location, p.status, p.type, p.create_user_id, p.return_user_id, p.name, m.postid";

    @Modifying
    @Query(value = GET_ALL_POST_WITH_MEDIA, nativeQuery = true)
    List<IPostReponseDTO> getAllPostWithMedia();
}
