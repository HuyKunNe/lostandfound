package com.swp391.lostandfound.controller;

import com.swp391.lostandfound.service.ItemService;

import org.springframework.stereotype.Controller;

@Controller
public class ItemController {
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

}
