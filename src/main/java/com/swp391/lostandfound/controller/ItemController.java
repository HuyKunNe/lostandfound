package com.swp391.lostandfound.controller;

import com.swp391.lostandfound.DTO.ItemAddDTO;
import com.swp391.lostandfound.DTO.ItemUpdateDTO;
import com.swp391.lostandfound.dataFormat.ItemData;
import com.swp391.lostandfound.dataFormat.ListItems;
import com.swp391.lostandfound.service.ItemService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@CrossOrigin("*")
public class ItemController {
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/item")
    ListItems GetAllItems() {
        ListItems items = new ListItems();
        items.setData(itemService.getAllItems());
        if (items.getData().isEmpty()) {
            items.setMessage("List is Empty");
            items.setStatus("Success");
        } else {
            items.setMessage("Get all items successfully");
            items.setStatus("Success");
        }
        return items;
    }

    @GetMapping("/item/{id}")
    ItemData findItemById(@PathVariable int id) {
        ItemData item = new ItemData();
        item.setItem(itemService.findItemById(id));
        if (item.getItem() != null) {
            item.setMessage("Find item successfully");
            item.setStatus("Success");
        } else {
            item.setMessage("Item is not exist");
            item.setStatus("Fail");
        }
        return item;
    }

    @PostMapping("/item")
    ItemData addItem(@RequestBody ItemAddDTO itemAddDTO) {
        ItemData item = new ItemData();
        item.setItem(itemService.addItem(itemAddDTO));
        if (item.getItem() != null) {
            item.setMessage("Add Item successfully");
            item.setStatus("Success");
        } else {
            item.setMessage("Add Failed");
            item.setStatus("Fail");
        }
        return item;
    }

    @PutMapping("/item/edit/{id}")
    ItemData updateItem(@PathVariable int id, @RequestBody ItemUpdateDTO itemUpdateDTO) {
        ItemData item = new ItemData();
        item.setItem(itemService.updateItem(id, itemUpdateDTO));
        if (item.getItem() != null) {
            item.setMessage("Update Item successfully");
            item.setStatus("Success");
        } else {
            item.setMessage("Update Failed");
            item.setStatus("Fail");
        }
        return item;
    }

    @DeleteMapping("/item/{id}")
    ItemData deleteItemById(@PathVariable int id) {
        ItemData item = new ItemData();
        if (itemService.deleteItemById(id)) {
            item.setMessage("Delete Item successfully");
            item.setStatus("Success");
        } else {
            item.setMessage("Item is not exist");
            item.setStatus("Fail");
        }
        return item;
    }
}
