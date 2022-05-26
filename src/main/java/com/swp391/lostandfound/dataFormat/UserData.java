package com.swp391.lostandfound.dataFormat;

import com.swp391.lostandfound.entity.User;

import lombok.Data;

@Data
public class UserData {

    private String message;
    private User user;
    private String status;
}
