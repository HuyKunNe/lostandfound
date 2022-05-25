package com.swp391.lostandfound.serviceImp;

import java.util.List;

import com.swp391.lostandfound.entity.ChestItem;
import com.swp391.lostandfound.repository.ChestItemRepository;
import com.swp391.lostandfound.service.ChestItemService;

import org.springframework.stereotype.Service;

@Service
public class ChestItemServiceImp implements ChestItemService {

    private ChestItemRepository chestItemRepository;

    public ChestItemServiceImp(ChestItemRepository chestItemRepository) {
        this.chestItemRepository = chestItemRepository;
    }

    @Override
    public List<ChestItem> getAllChestItems() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ChestItem addChestItem(ChestItem chestItem) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ChestItem updateChestItem(ChestItem chestItem) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ChestItem findChestItemById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteChestItemById(int id) {
        // TODO Auto-generated method stub
        return false;
    }

}
