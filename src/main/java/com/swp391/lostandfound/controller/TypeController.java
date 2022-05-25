package com.swp391.lostandfound.controller;

import com.swp391.lostandfound.service.TypeService;

import org.springframework.stereotype.Controller;

@Controller
public class TypeController {

    private TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

}
