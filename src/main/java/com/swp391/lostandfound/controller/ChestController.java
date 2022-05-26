package com.swp391.lostandfound.controller;

import java.util.List;

import com.swp391.lostandfound.DTO.ChestAddDTO;
import com.swp391.lostandfound.DTO.ChestUpdateDTO;
import com.swp391.lostandfound.dataFormat.ChestData;
import com.swp391.lostandfound.dataFormat.ListChests;
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
    public ListChests getAllChests() {
        ListChests chests = new ListChests();
        chests.setData(chestService.getAllChests());
        if (chests.getData().isEmpty()) {
            chests.setMessage("List is empty");
        } else {
            chests.setMessage("get all enable chests successfully");
        }
        chests.setStatus("Success");
        return chests;
    }

    @GetMapping("/chest/{id}")
    public ChestData getChestById(int id) {
        ChestData result = new ChestData();
        result.setChest(chestService.findChestById(id));
        if (result.getChest() != null) {
            result.setMessage("Find Type successfully");
            result.setStatus("Success");
        } else {
            result.setMessage("Type is not found");
            result.setStatus("Fail");
        }
        return result;
    }

    @PostMapping("/chest")
    public ChestData addChest(ChestAddDTO chest) {
        ChestData result = new ChestData();
        result.setChest(chestService.addChest(chest));
        result.setMessage("Create successfully");
        result.setStatus("Success");
        return result;
    }

    @PutMapping("/chest/edit/{id}")
    public ChestData editChestById(int id, ChestUpdateDTO dto) {
        ChestData result = new ChestData();
        Chest chest = chestService.updateChest(id, dto);
        if (chest != null) {
            result.setMessage("Update type successfully");
            result.setChest(chest);
            result.setStatus("Success");
        } else {
            result.setMessage("Chest is not exist");
            result.setStatus("Fail");
        }
        return result;
    }

    @DeleteMapping("/chest/{id}")
    public ChestData deleteChestById(int id) {
        ChestData result = new ChestData();
        if (chestService.deleteChestById(id)) {
            result.setMessage("Delete Chest successfully");
            result.setStatus("Success");
        } else {
            result.setMessage("Chest is not exist");
            result.setStatus("Fail");
        }
        return result;
    }
}
