package com.swp391.lostandfound.controller;

import com.swp391.lostandfound.DTO.ChestItemAddDTO;
import com.swp391.lostandfound.DTO.ChestItemUpdateDTO;
import com.swp391.lostandfound.dataFormat.ChestItemData;
import com.swp391.lostandfound.dataFormat.ListChestItems;
import com.swp391.lostandfound.service.ChestItemService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChestItemController {

    private ChestItemService chestItemService;

    public ChestItemController(ChestItemService chestItemService) {
        this.chestItemService = chestItemService;
    }

    @GetMapping("/chestItem")
    ListChestItems getChestItems() {
        ListChestItems list = new ListChestItems();
        list.setData(chestItemService.getAllChestItems());
        if (list.getData().isEmpty()) {
            list.setMessage("List is Empty");
            list.setStatus("Success");
        } else {
            list.setMessage("Get all chest items Succcessfully");
            list.setStatus("Success");
        }
        return list;
    }

    @GetMapping("/chestItem/{id}")
    ChestItemData findChestItemById(@PathVariable int id) {
        ChestItemData chestItemData = new ChestItemData();
        chestItemData.setChestItem(chestItemService.findChestItemById(id));
        if (chestItemData.getChestItem() != null) {
            chestItemData.setMessage("Find chest item successfully");
            chestItemData.setStatus("Success");
        } else {
            chestItemData.setMessage("ChestItem does not exist");
            chestItemData.setStatus("Fail");
        }
        return chestItemData;
    }

    @PostMapping("/chestItem")
    ChestItemData createChestItem(ChestItemAddDTO chestItemAddDTO) {
        ChestItemData chestItemData = new ChestItemData();
        chestItemData.setChestItem(chestItemService.addChestItem(chestItemAddDTO));
        if (chestItemData.getChestItem() != null) {
            chestItemData.setMessage("create Chest Item successfully");
            chestItemData.setStatus("Success");
        } else {
            chestItemData.setMessage("create Chest Item Fail");
            chestItemData.setStatus("Fail");
        }
        return chestItemData;
    }

    @PutMapping("/chestItem/edit/{id}")
    ChestItemData updateChestItem(@PathVariable int id, ChestItemUpdateDTO chestItemUpdateDTO) {
        ChestItemData chestItemData = new ChestItemData();
        chestItemData.setChestItem(chestItemService.updateChestItem(id, chestItemUpdateDTO));
        if (chestItemData.getChestItem() != null) {
            chestItemData.setMessage("Update Chest Item successfully");
            chestItemData.setStatus("Success");
        } else {
            chestItemData.setMessage("Update Chest Item Fail");
            chestItemData.setStatus("Fail");
        }
        return chestItemData;
    }

    @DeleteMapping("/chestItem/{id}")
    ChestItemData deleteChestItemById(@PathVariable int id) {
        ChestItemData chestItemData = new ChestItemData();
        if (chestItemService.deleteChestItemById(id)) {
            chestItemData.setMessage("Delete Chest Item successfully");
            chestItemData.setStatus("Success");
        } else {
            chestItemData.setMessage("Delete Chest Item Fail");
            chestItemData.setStatus("Fail");
        }
        return chestItemData;
    }
}
