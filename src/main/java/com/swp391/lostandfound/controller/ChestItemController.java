package com.swp391.lostandfound.controller;

import com.swp391.lostandfound.service.ChestItemService;

import org.springframework.stereotype.Controller;

@Controller
public class ChestItemController {

    private ChestItemService chestItemService;

    public ChestItemController(ChestItemService chestItemService) {
        this.chestItemService = chestItemService;
    }

}
