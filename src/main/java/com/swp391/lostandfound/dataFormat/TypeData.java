package com.swp391.lostandfound.dataFormat;

import com.swp391.lostandfound.entity.Type;

import lombok.Data;

@Data
public class TypeData {
    private String message;
    private Type type;
    private String status;
}
