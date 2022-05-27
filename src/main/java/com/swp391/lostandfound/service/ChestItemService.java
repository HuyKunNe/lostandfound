package com.swp391.lostandfound.service;

import java.util.List;

import com.swp391.lostandfound.DTO.ChestItemAddDTO;
import com.swp391.lostandfound.DTO.ChestItemUpdateDTO;
import com.swp391.lostandfound.entity.ChestItem;

public interface ChestItemService {
    List<ChestItem> getAllChestItems();

    ChestItem addChestItem(ChestItemAddDTO chestItemAddDTO);

    ChestItem updateChestItem(int id, ChestItemUpdateDTO chestItemUpdateDTO);

    ChestItem findChestItemById(int id);

    boolean deleteChestItemById(int id);
}
