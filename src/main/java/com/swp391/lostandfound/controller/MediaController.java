package com.swp391.lostandfound.controller;

import com.swp391.lostandfound.service.MediaService;

import org.springframework.stereotype.Controller;

@Controller
public class MediaController {

    private MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

}
