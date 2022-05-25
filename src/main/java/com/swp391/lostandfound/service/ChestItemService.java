package com.swp391.lostandfound.service;

import java.util.List;

import com.swp391.lostandfound.entity.ChestItem;

public interface ChestItemService {
    List<ChestItem> getAllChestItems();

    ChestItem addChestItem(ChestItem chestItem);

    ChestItem updateChestItem(ChestItem chestItem);

    ChestItem findChestItemById(int id);

    boolean deleteChestItemById(int id);
}
