package com.swp391.lostandfound.DTO;

import lombok.Data;

@Data
public class UserActivityAddDTO {
    private String Date;
    private int type;
    private int postId;
    private int userId;
}
