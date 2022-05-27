package com.swp391.lostandfound.service;

import java.util.List;

import com.swp391.lostandfound.DTO.ItemAddDTO;
import com.swp391.lostandfound.DTO.ItemUpdateDTO;
import com.swp391.lostandfound.entity.Item;

public interface ItemService {
    List<Item> getAllItems();

    Item addItem(ItemAddDTO itemAddDTO);

    Item updateItem(int id, ItemUpdateDTO itemUpdateDTO);

    Item findItemById(int id);

    boolean deleteItemById(int id);
}
