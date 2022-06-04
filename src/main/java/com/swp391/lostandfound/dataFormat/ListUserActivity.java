package com.swp391.lostandfound.dataFormat;

import com.swp391.lostandfound.entity.UserActivity;
import lombok.Data;

import java.util.List;

@Data
public class ListUserActivity {
    private String message;
    private List<UserActivity> data;
    private String status;
}
