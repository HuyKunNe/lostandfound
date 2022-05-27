package com.swp391.lostandfound.dataFormat;

import com.swp391.lostandfound.entity.Item;

import lombok.Data;

@Data
public class ItemData {
    private String message;
    private Item item;
    private String status;
}
