package com.swp391.lostandfound.service;

import java.util.List;

import com.swp391.lostandfound.entity.Chest;

public interface ChestService {

    List<Chest> getAllChests();

    Chest addChest(Chest chest);

    Chest updateChest(Chest chest);

    Chest findChestById(int id);

    boolean deleteChestById(int id);
}
