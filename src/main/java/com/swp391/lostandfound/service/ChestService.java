package com.swp391.lostandfound.service;

import java.util.List;

import com.swp391.lostandfound.DTO.ChestAddDTO;
import com.swp391.lostandfound.DTO.ChestUpdateDTO;
import com.swp391.lostandfound.entity.Chest;

public interface ChestService {

    List<Chest> getAllChests();

    Chest addChest(ChestAddDTO chestAddDTO);

    Chest updateChest(int id, ChestUpdateDTO chestUpdateDTO);

    Chest findChestById(int id);

    boolean deleteChestById(int id);

    List<Chest> getAllChestsAvailable();

}
