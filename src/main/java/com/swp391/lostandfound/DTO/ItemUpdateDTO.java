package com.swp391.lostandfound.DTO;

import lombok.Data;

@Data
public class ItemUpdateDTO {
    private String name;
    private String description;
    private String location;
    private int status;
    private String receivedDate;
    private String returnedDate;
    private int typeId;
    private int postId;
}
