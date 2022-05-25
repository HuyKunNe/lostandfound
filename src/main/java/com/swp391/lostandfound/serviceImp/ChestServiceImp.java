package com.swp391.lostandfound.serviceImp;

import java.util.List;

import com.swp391.lostandfound.entity.Chest;
import com.swp391.lostandfound.repository.ChestRepository;
import com.swp391.lostandfound.service.ChestService;

import org.springframework.stereotype.Service;

@Service
public class ChestServiceImp implements ChestService {

    private ChestRepository chestRepository;

    public ChestServiceImp(ChestRepository chestRepository) {
        this.chestRepository = chestRepository;
    }

    @Override
    public List<Chest> getAllChests() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Chest addChest(Chest chest) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Chest updateChest(Chest chest) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Chest findChestById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteChestById(int id) {
        // TODO Auto-generated method stub
        return false;
    }

}
