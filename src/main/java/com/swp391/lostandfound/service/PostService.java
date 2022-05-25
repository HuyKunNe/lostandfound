package com.swp391.lostandfound.service;

import java.util.List;

import com.swp391.lostandfound.entity.Post;

public interface PostService {
    List<Post> getAllPosts();

    Post addPost(Post post);

    Post updatePost(Post post);

    Post findPostById(int id);

    boolean deletePostById(int id);
}
