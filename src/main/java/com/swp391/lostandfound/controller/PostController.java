package com.swp391.lostandfound.controller;

import com.swp391.lostandfound.DTO.PostAddDTO;
import com.swp391.lostandfound.DTO.PostUpdateByUserDTO;
import com.swp391.lostandfound.dataFormat.ListMedias;
import com.swp391.lostandfound.dataFormat.ListPosts;
import com.swp391.lostandfound.dataFormat.PostData;
import com.swp391.lostandfound.service.MediaService;
import com.swp391.lostandfound.service.PostService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    private PostService postService;
    private MediaService mediaService;

    public PostController(PostService postService, MediaService mediaService) {
        this.postService = postService;
        this.mediaService = mediaService;
    }

    @GetMapping("/post")
    ListPosts getAllPosts() {
        ListPosts posts = new ListPosts();
        posts.setData(postService.getAllPosts());
        if (posts.getData().isEmpty()) {
            posts.setMessage("List is empty");
            posts.setStatus("Success");
        } else {
            posts.setMessage("Get all posts successfully");
            posts.setStatus("Success");
        }
        return posts;
    }

    @GetMapping("/post/{id}")
    PostData getPostById(@PathVariable int id) {
        PostData post = new PostData();
        post.setPost(postService.findPostById(id));
        if (post.getPost() != null) {
            post.setMessage("Find post successfully");
            post.setStatus("Success");
        } else {
            post.setMessage("Post is not found");
            post.setStatus("Fail");
        }
        return post;
    }

    @GetMapping("/post/media")
    ListMedias getMediaByPostId(int postId) {
        ListMedias media = new ListMedias();
        media.setData(mediaService.findMediaByPostId(postId));
        if (media.getData().isEmpty()) {
            media.setMessage("List is empty");
            media.setStatus("Success");
        } else {
            media.setMessage("Get all media by post successfully");
            media.setStatus("Success");
        }
        return media;
    }

    @PostMapping("/post/addLostPost")
    PostData addLostPost(PostAddDTO postAddDTO) {
        PostData post = new PostData();
        post.setPost(postService.addLostPost(postAddDTO));
        if (post.getPost() != null) {
            post.setMessage("Add post successfully");
            post.setStatus("Success");
        } else {
            post.setMessage("Add failed");
            post.setStatus("Fail");
        }
        return post;
    }

    @PostMapping("/post/addFindPost")
    PostData addFindPost(PostAddDTO postAddDTO) {
        PostData post = new PostData();
        post.setPost(postService.addFindPost(postAddDTO));
        if (post.getPost() != null) {
            post.setMessage("Add post successfully");
            post.setStatus("Success");
        } else {
            post.setMessage("Add failed");
            post.setStatus("Fail");
        }
        return post;
    }

    @PutMapping("/post/{id}")
    PostData confirmFoundedPostByAdmin(@PathVariable int id, int returnUserId) {
        PostData post = new PostData();
        post.setPost(postService.confirmFoundedPostByAdmin(id, returnUserId));
        if (post.getPost() != null) {
            post.setMessage("Confirm successfully");
            post.setStatus("Success");
        } else {
            post.setMessage("Post is not exist");
            post.setStatus("Fail");
        }
        return post;
    }

    @PutMapping("/post/edit/{id}")
    PostData updatePostByUser(@PathVariable int id, PostUpdateByUserDTO postUpdateDTO) {
        PostData post = new PostData();
        post.setPost(postService.updatePostByUser(id, postUpdateDTO));
        if (post.getPost() != null) {
            post.setMessage("Update post successfully");
            post.setStatus("Success");
        } else {
            post.setMessage("Update failed");
            post.setStatus("Fail");
        }
        return post;
    }

    @DeleteMapping("/post/{id}")
    PostData deletePostById(@PathVariable int id) {
        PostData post = new PostData();
        if (postService.deletePostById(id)) {
            post.setMessage("Delete Post successfully");
            post.setStatus("Success");
        } else {
            post.setMessage("Post is not exist");
            post.setStatus("Fail");
        }
        return post;
    }

    @GetMapping("/post/enablePosts")
    ListPosts getAllEnabledPosts() {
        ListPosts post = new ListPosts();
        post.setData(postService.getAllEnabledPosts());
        if (post.getData().isEmpty()) {
            post.setMessage("List is empty");
            post.setStatus("Fail");
        } else {
            post.setMessage("Get all enable post successfully");
            post.setStatus("Success");
        }
        return post;
    }

    @GetMapping("/post/lostPosts")
    ListPosts getAllLostPosts() {
        ListPosts post = new ListPosts();
        post.setData(postService.getAllLostPosts());
        if (post.getData().isEmpty()) {
            post.setMessage("List is empty");
            post.setStatus("Fail");
        } else {
            post.setMessage("Get all enable post successfully");
            post.setStatus("Success");
        }
        return post;
    }

    @GetMapping("/post/findPosts")
    ListPosts getAllFindPosts() {
        ListPosts post = new ListPosts();
        post.setData(postService.getAllFindPost());
        if (post.getData().isEmpty()) {
            post.setMessage("List is empty");
            post.setStatus("Fail");
        } else {
            post.setMessage("Get all enable post successfully");
            post.setStatus("Success");
        }
        return post;
    }

    @GetMapping("/post/NotConfirmPosts")
    ListPosts getAllNotConfirmPosts() {
        ListPosts post = new ListPosts();
        post.setData(postService.getALLNotConfirmedPosts());
        if (post.getData().isEmpty()) {
            post.setMessage("List is empty");
            post.setStatus("Fail");
        } else {
            post.setMessage("Get all enable post successfully");
            post.setStatus("Success");
        }
        return post;
    }

    @GetMapping("/post/ConfirmPosts")
    ListPosts getAllConfirmedPosts() {
        ListPosts post = new ListPosts();
        post.setData(postService.getAllConfirmedPosts());
        if (post.getData().isEmpty()) {
            post.setMessage("List is empty");
            post.setStatus("Fail");
        } else {
            post.setMessage("Get all enable post successfully");
            post.setStatus("Success");
        }
        return post;
    }

}
