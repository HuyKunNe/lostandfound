package com.swp391.lostandfound.dataFormat;

import java.util.List;

import com.swp391.lostandfound.entity.ChestItem;

import lombok.Data;

@Data
public class ListChestItems {
    private String message;
    private List<ChestItem> data;
    private String status;
}
