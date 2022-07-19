package com.swp391.lostandfound.service;

import java.util.List;

import com.swp391.lostandfound.DTO.PostAddDTO;
import com.swp391.lostandfound.DTO.PostUpdateByUserDTO;
import com.swp391.lostandfound.DTO.responseDTO.PostResponseDTO;
import com.swp391.lostandfound.entity.Post;

public interface PostService {
    List<PostResponseDTO> getAllPosts();

    Post addLostPost(PostAddDTO postAddDTO);

    Post addFindPost(PostAddDTO postAddDTO);

    Post updatePostByUser(int id, PostUpdateByUserDTO postUpdateDTO);

    Post confirmFoundedPostByAdmin(int id, int returnUserId);

    Post findPostById(int id);

    boolean deletePostById(int id);

    List<Post> getAllEnabledPosts();

    List<Post> getAllLostPosts();

    List<Post> getAllFindPost();

    List<Post> getALLNotConfirmedPosts();

    List<Post> getAllConfirmedPosts();

    Post confirmFoundedPostByLostUser(int id, int lostUserId);
}
