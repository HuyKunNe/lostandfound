package com.swp391.lostandfound.dataFormat;

import java.util.List;

import com.swp391.lostandfound.entity.User;

import lombok.Data;

@Data
public class ListUsersData {
    private String message;
    private List<User> data;
    private String status;
}
