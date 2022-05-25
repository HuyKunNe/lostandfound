package com.swp391.lostandfound.serviceImp;

import java.util.List;

import com.swp391.lostandfound.entity.Item;
import com.swp391.lostandfound.repository.ItemRepository;
import com.swp391.lostandfound.service.ItemService;

import org.springframework.stereotype.Service;

@Service
public class ItemServiceImp implements ItemService {

    private ItemRepository itemRepository;

    public ItemServiceImp(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Item addItem(Item item) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Item updateItem(Item item) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Item findItemById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteItemById(int id) {
        // TODO Auto-generated method stub
        return false;
    }

}
