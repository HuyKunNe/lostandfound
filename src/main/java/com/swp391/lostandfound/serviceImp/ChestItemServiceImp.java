package com.swp391.lostandfound.serviceImp;

import java.util.List;

import com.swp391.lostandfound.DTO.ChestItemAddDTO;
import com.swp391.lostandfound.DTO.ChestItemUpdateDTO;
import com.swp391.lostandfound.entity.ChestItem;
import com.swp391.lostandfound.repository.ChestItemRepository;
import com.swp391.lostandfound.repository.ChestRepository;
import com.swp391.lostandfound.repository.ItemRepository;
import com.swp391.lostandfound.service.ChestItemService;

import org.springframework.stereotype.Service;

@Service
public class ChestItemServiceImp implements ChestItemService {

    private ChestItemRepository chestItemRepository;
    private ChestRepository chestRepository;
    private ItemRepository itemRepository;

    public ChestItemServiceImp(ChestItemRepository chestItemRepository, ChestRepository chestRepository,
            ItemRepository itemRepository) {
        this.chestItemRepository = chestItemRepository;
        this.chestRepository = chestRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public List<ChestItem> getAllChestItems() {
        return chestItemRepository.findChestItemByStatus(0);
    }

    @Override
    public ChestItem addChestItem(ChestItemAddDTO chestItemAddDTO) {
        ChestItem chestItem = new ChestItem();
        chestItem.setFromDate(chestItemAddDTO.getFromDate());
        chestItem.setToDate(chestItemAddDTO.getToDate());
        chestItem.setSlot(chestItemAddDTO.getSlot());
        chestItem.setStatus(0);
        if (chestRepository.existsById(chestItemAddDTO.getChestId())) {
            chestItem.setChest(chestRepository.findById(chestItemAddDTO.getChestId()).get());
        } else if (itemRepository.existsById(chestItemAddDTO.getItemId())) {
            chestItem.setItem(itemRepository.findById(chestItemAddDTO.getItemId()).get());
        } else {
            return null;
        }
        return chestItemRepository.save(chestItem);

    }

    @Override
    public ChestItem updateChestItem(int id, ChestItemUpdateDTO chestItemUpdateDTO) {
        if (chestItemRepository.existsById(id)) {
            ChestItem chestItem = chestItemRepository.findById(id).get();
            chestItem.setFromDate(chestItemUpdateDTO.getFromDate());
            chestItem.setToDate(chestItemUpdateDTO.getToDate());
            chestItem.setSlot(chestItemUpdateDTO.getSlot());
            chestItem.setStatus(chestItemUpdateDTO.getStatus());
            if (chestRepository.existsById(chestItemUpdateDTO.getChestId())) {
                chestItem.setChest(chestRepository.findById(chestItemUpdateDTO.getChestId()).get());
            } else if (itemRepository.existsById(chestItemUpdateDTO.getItemId())) {
                chestItem.setItem(itemRepository.findById(chestItemUpdateDTO.getItemId()).get());
            } else {
                return null;
            }
            return chestItemRepository.save(chestItem);
        } else {
            return null;
        }
    }

    @Override
    public ChestItem findChestItemById(int id) {
        if (chestItemRepository.existsById(id)) {
            return chestItemRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteChestItemById(int id) {
        if (chestItemRepository.existsById(id)) {
            return chestItemRepository.updateStatusById(1, id);
        } else {
            return false;
        }
    }

}
