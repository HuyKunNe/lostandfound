package com.swp391.lostandfound.dataFormat;

import com.swp391.lostandfound.entity.ChestItem;
import com.swp391.lostandfound.entity.UserActivity;
import lombok.Data;

@Data
public class UserActivityData {
    private String message;
    private UserActivity userActivity;
    private String status;
}
