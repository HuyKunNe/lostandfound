package com.swp391.lostandfound.repository;

import java.util.List;

import com.swp391.lostandfound.DTO.responseDTO.IPostReponseDTO;
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

    public final static String GET_ALL_POST_WITH_MEDIA = "select p.id, p.description, p.location, p.status, p.type, p.create_user_id, p.return_user_id, p.name, m.postid "
            + " from post p, media m"
            + " where p.status = ?1 and p.id in (select distinct m.postid from media)"
            + "group by p.id, p.description, p.location, p.status, p.type, p.create_user_id, p.return_user_id, p.name, m.postid";

    @Modifying
    @Query(value = GET_ALL_POST_WITH_MEDIA, nativeQuery = true)
    List<IPostReponseDTO> getAllPostWithMedia(int status);

    public final static String GET_ALL_POST_BY_TYPE_WITH_MEDIA = "select p.id, p.description, p.location, p.status, p.type, p.create_user_id, p.return_user_id, p.name, m.postid "
            + " from post p, media m"
            + " where p.type = ?1 and p.status = ?2 and p.id in (select distinct m.postid from media)"
            + "group by p.id, p.description, p.location, p.status, p.type, p.create_user_id, p.return_user_id, p.name, m.postid";

    @Modifying
    @Query(value = GET_ALL_POST_BY_TYPE_WITH_MEDIA, nativeQuery = true)
    List<IPostReponseDTO> getAllPostByTypeWithMedia(int type, int status);

    public final static String GET_ALL_POST_WITH_MEDIA_BY_STATUS_LESS_THAN = "select p.id, p.description, p.location, p.status, p.type, p.create_user_id, p.return_user_id, p.name, m.postid "
            + " from post p, media m"
            + " where p.status < ?1 and p.id in (select distinct m.postid from media)"
            + "group by p.id, p.description, p.location, p.status, p.type, p.create_user_id, p.return_user_id, p.name, m.postid";

    @Modifying
    @Query(value = GET_ALL_POST_WITH_MEDIA_BY_STATUS_LESS_THAN, nativeQuery = true)
    List<IPostReponseDTO> getAllPostByStatusLessThan(int status);

    public final static String GET_ALL_POST_WITH_MEDIA_BY_STATUS = "select p.id, p.description, p.location, p.status, p.type, p.create_user_id, p.return_user_id, p.name, m.postid "
            + " from post p, media m"
            + " where p.status = ?1 and p.id in (select distinct m.postid from media)"
            + "group by p.id, p.description, p.location, p.status, p.type, p.create_user_id, p.return_user_id, p.name, m.postid";

    @Modifying
    @Query(value = GET_ALL_POST_WITH_MEDIA_BY_STATUS, nativeQuery = true)
    List<IPostReponseDTO> getAllPostByStatus(int status);
}
