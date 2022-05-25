package com.swp391.lostandfound.serviceImp;

import java.util.List;

import com.swp391.lostandfound.entity.Post;
import com.swp391.lostandfound.repository.PostRepository;
import com.swp391.lostandfound.service.PostService;

import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements PostService {

    private PostRepository postRepository;

    public PostServiceImp(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Post addPost(Post post) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Post updatePost(Post post) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Post findPostById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deletePostById(int id) {
        // TODO Auto-generated method stub
        return false;
    }

}
