package com.swp391.lostandfound.dataFormat;

import com.swp391.lostandfound.entity.Chest;

import lombok.Data;

@Data
public class ChestData {
    private String message;
    private Chest chest;
    private String status;
}
