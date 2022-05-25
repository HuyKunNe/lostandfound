package com.swp391.lostandfound.service;

import java.util.List;

import com.swp391.lostandfound.entity.Item;

public interface ItemService {
    List<Item> getAllItems();

    Item addItem(Item item);

    Item updateItem(Item item);

    Item findItemById(int id);

    boolean deleteItemById(int id);
}
