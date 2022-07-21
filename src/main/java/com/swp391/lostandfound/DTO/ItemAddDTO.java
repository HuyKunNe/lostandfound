package com.swp391.lostandfound.DTO;

import lombok.Data;

@Data
public class ItemAddDTO {
    private String name;
    private String description;
    private String location;
    private String returnedDate;
    private int typeId;
}
