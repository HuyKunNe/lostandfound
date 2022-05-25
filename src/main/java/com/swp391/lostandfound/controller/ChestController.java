package com.swp391.lostandfound.controller;

import com.swp391.lostandfound.service.ChestService;

import org.springframework.stereotype.Controller;

@Controller
public class ChestController {
    private ChestService chestService;

    public ChestController(ChestService chestService) {
        this.chestService = chestService;
    }

}
