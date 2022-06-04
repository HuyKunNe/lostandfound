package com.swp391.lostandfound.DTO;

import lombok.Data;

@Data
public class ChestItemUpdateDTO {
    private String fromDate;
    private String toDate;
    private int status;
    private int slot;
    private int chestId;
    private int itemId;
}
