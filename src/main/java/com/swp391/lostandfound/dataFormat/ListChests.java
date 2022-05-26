package com.swp391.lostandfound.dataFormat;

import java.util.List;

import com.swp391.lostandfound.entity.Chest;

import lombok.Data;

@Data
public class ListChests {
    private String message;
    private List<Chest> data;
    private String status;
}
