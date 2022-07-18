package com.swp391.lostandfound.DTO;

import lombok.Data;

@Data
public class PostAddDTO {
    private String name;
    private String location;
    private String description;
    private int userId;
}
