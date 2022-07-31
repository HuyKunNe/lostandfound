package com.swp391.lostandfound.service;

import java.util.List;

import com.swp391.lostandfound.DTO.ItemAddDTO;
import com.swp391.lostandfound.DTO.ItemUpdateDTO;
import com.swp391.lostandfound.entity.Item;

public interface ItemService {

    Item addItem(ItemAddDTO item);

    List<Item> getAllItems();

    Item updateItem(int id, ItemUpdateDTO itemUpdateDTO);

    Item findItemById(int id);

    boolean deleteItemById(int id);
}
