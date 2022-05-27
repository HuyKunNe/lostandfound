package com.swp391.lostandfound.dataFormat;

import com.swp391.lostandfound.entity.ChestItem;

import lombok.Data;

@Data
public class ChestItemData {
    private String message;
    private ChestItem chestItem;
    private String status;
}
