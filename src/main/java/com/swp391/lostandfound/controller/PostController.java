package com.swp391.lostandfound.controller;

import com.swp391.lostandfound.service.PostService;

import org.springframework.stereotype.Controller;

@Controller
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

}
