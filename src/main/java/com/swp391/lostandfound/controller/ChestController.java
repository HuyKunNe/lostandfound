package com.swp391.lostandfound.controller;

import java.util.List;

import com.swp391.lostandfound.DTO.ChestAddDTO;
import com.swp391.lostandfound.DTO.ChestUpdateDTO;
import com.swp391.lostandfound.entity.Chest;
import com.swp391.lostandfound.service.ChestService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChestController {
    private ChestService chestService;

    public ChestController(ChestService chestService) {
        this.chestService = chestService;
    }

    @GetMapping("/chest")
    public List<Chest> getAllChests() {
        return chestService.getAllChests();
    }

    @GetMapping("/chest/{id}")
    public Chest getChestById(int id) {
        return chestService.findChestById(id);
    }

    @PostMapping("/chest")
    public Chest addChest(ChestAddDTO chest) {
        return chestService.addChest(chest);
    }

    @PutMapping("/chest/edit/{id}")
    public boolean editChestById(int id, ChestUpdateDTO dto) {
        return chestService.updateChest(id, dto);
    }

    @DeleteMapping("/chest/{id}")
    public boolean deleteChestById(int id) {
        return chestService.deleteChestById(id);
    }
}
