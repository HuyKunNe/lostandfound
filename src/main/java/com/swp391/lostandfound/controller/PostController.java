package com.swp391.lostandfound.controller;

import com.swp391.lostandfound.DTO.PostAddDTO;
import com.swp391.lostandfound.DTO.PostUpdateByUserDTO;
import com.swp391.lostandfound.dataFormat.ListMedias;
import com.swp391.lostandfound.dataFormat.ListPostResponeData;
import com.swp391.lostandfound.dataFormat.PostData;
import com.swp391.lostandfound.service.MediaService;
import com.swp391.lostandfound.service.PostService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin("*")
public class PostController {

    private PostService postService;
    private MediaService mediaService;

    public PostController(PostService postService, MediaService mediaService) {
        this.postService = postService;
        this.mediaService = mediaService;
    }

    @GetMapping("/post")
    public ListPostResponeData getAllPosts() {
        ListPostResponeData posts = new ListPostResponeData();
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
    public PostData getPostById(@PathVariable int id) {
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
    public ListMedias getMediaByPostId(int postId) {
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
    public PostData addLostPost(@RequestBody PostAddDTO postAddDTO) {
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
    public PostData addFindPost(@RequestBody PostAddDTO postAddDTO) {
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
    public PostData confirmFoundedPostByAdmin(@PathVariable int id, int returnUserId) {
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
    public PostData updatePostByUser(@PathVariable int id,@RequestBody  PostUpdateByUserDTO postUpdateDTO) {
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
    public PostData deletePostById(@PathVariable int id) {
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

    @GetMapping("/post/lostPosts")
    public ListPostResponeData getAllLostPosts() {
        ListPostResponeData post = new ListPostResponeData();
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
    public ListPostResponeData getAllFindPosts() {
        ListPostResponeData post = new ListPostResponeData();
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
    public ListPostResponeData getAllNotConfirmPosts() {
        ListPostResponeData post = new ListPostResponeData();
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
    public ListPostResponeData getAllConfirmedPosts() {
        ListPostResponeData post = new ListPostResponeData();
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
