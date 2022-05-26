package com.swp391.lostandfound.dataFormat;

import java.util.List;

import com.swp391.lostandfound.entity.Type;

import lombok.Data;

@Data
public class ListTypesData {
    private String message;
    private List<Type> data;
    private String status;
}
