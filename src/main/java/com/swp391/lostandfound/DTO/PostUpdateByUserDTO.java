package com.swp391.lostandfound.DTO;

import lombok.Data;

@Data
public class PostUpdateByUserDTO {
    private String name;
    private String location;
    private String description;
    private int status;
}
