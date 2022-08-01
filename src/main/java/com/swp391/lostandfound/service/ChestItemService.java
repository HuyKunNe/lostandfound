package com.swp391.lostandfound.service;

import java.util.List;
import com.swp391.lostandfound.DTO.ChestItemUpdateDTO;
import com.swp391.lostandfound.entity.Chest;
import com.swp391.lostandfound.entity.ChestItem;
import com.swp391.lostandfound.entity.Item;

public interface ChestItemService {
    List<ChestItem> getAllChestItems();

    boolean addChestItem(Chest chest, List<Item> item);

    ChestItem updateChestItem(int id, ChestItemUpdateDTO chestItemUpdateDTO);

    ChestItem findChestItemById(int id);

    boolean deleteChestItemById(int id);
}
