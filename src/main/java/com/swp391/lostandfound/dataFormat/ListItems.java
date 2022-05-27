package com.swp391.lostandfound.dataFormat;

import java.util.List;

import com.swp391.lostandfound.entity.Item;

import lombok.Data;

@Data
public class ListItems {

    private String message;
    private List<Item> data;
    private String status;
}
