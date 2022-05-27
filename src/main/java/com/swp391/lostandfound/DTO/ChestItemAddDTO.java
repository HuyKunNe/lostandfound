package com.swp391.lostandfound.DTO;

import lombok.Data;

@Data
public class ChestItemAddDTO {
    private String fromDate;
    private String toDate;
    private int slot;
    private int chestId;
    private int itemId;
}
