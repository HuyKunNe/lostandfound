package com.swp391.lostandfound.DTO;

import lombok.Data;

@Data
public class ChestUpdateDTO {
    private String name;
    private String description;
    private int status;
    private String location;
}
