package com.swp391.lostandfound.serviceImp;

import java.util.List;

import com.swp391.lostandfound.DTO.PostAddDTO;
import com.swp391.lostandfound.DTO.PostUpdateByUserDTO;
import com.swp391.lostandfound.entity.Post;
import com.swp391.lostandfound.repository.PostRepository;
import com.swp391.lostandfound.repository.UserRepository;
import com.swp391.lostandfound.service.PostService;

import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements PostService {

    // type = 0 -> lost post
    // type = 1 -> find post
    // status = 0 -> not found
    // status = 1 -> found
    // status = 2 -> is delete

    private PostRepository postRepository;
    private UserRepository userRepository;

    public PostServiceImp(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public boolean deletePostById(int id) {
        if (postRepository.existsById(id)) {
            postRepository.UpdateStatusById(2, id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Post> getAllConfirmedPosts() {
        return postRepository.findPostByStatus(1);
    }

    @Override
    public List<Post> getAllEnabledPosts() {
        return postRepository.findPostByStatusLessThan(2);
    }

    public List<Post> getAllLostPosts() {
        return postRepository.findPostByType(1);
    }

    @Override
    public List<Post> getAllFindPost() {
        return postRepository.findPostByType(0);
    }

    @Override
    public List<Post> getALLNotConfirmedPosts() {
        return postRepository.findPostByTypeAndStatus(0, 0);
    }

    @Override
    public Post addLostPost(PostAddDTO postAddDTO) {
        Post post = new Post();
        post.setName(postAddDTO.getName());
        post.setDescription(postAddDTO.getDescription());
        post.setLocation(postAddDTO.getLocation());
        post.setType(1);
        post.setStatus(0);
        if (userRepository.existsById(postAddDTO.getUserId())) {
            post.setUserReturn(userRepository.findById(postAddDTO.getUserId()).get());
            return postRepository.save(post);
        } else {
            return null;
        }
    }

    @Override
    public Post addFindPost(PostAddDTO postAddDTO) {
        Post post = new Post();
        post.setName(postAddDTO.getName());
        post.setDescription(postAddDTO.getDescription());
        post.setLocation(postAddDTO.getLocation());
        post.setType(0);
        post.setStatus(0);
        if (userRepository.existsById(postAddDTO.getUserId())) {
            post.setUserCreate(userRepository.findById(postAddDTO.getUserId()).get());
            return postRepository.save(post);
        } else {
            return null;
        }
    }

    @Override
    public Post updatePostByUser(int id, PostUpdateByUserDTO postUpdateDTO) {
        if (postRepository.existsById(id)) {
            Post post = postRepository.findById(id).get();
            post.setName(postUpdateDTO.getName());
            post.setDescription(postUpdateDTO.getDescription());
            post.setLocation(postUpdateDTO.getLocation());
            post.setStatus(postUpdateDTO.getStatus());
            return postRepository.save(post);
        } else {
            return null;
        }
    }

    @Override
    public Post confirmFoundedPostByAdmin(int id, int returnUserId) {
        if (postRepository.existsById(id)) {
            Post post = postRepository.findById(id).get();
            post.setUserReturn(userRepository.findById(returnUserId).get());
            post.setStatus(1);
            return postRepository.save(post);
        } else {
            return null;
        }
    }

    @Override
    public Post confirmFoundedPostByLostUser(int id, int lostUserId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Post findPostById(int id) {
        if (postRepository.existsById(id)) {
            return postRepository.findById(id).get();
        } else {
            return null;
        }
    }

}
