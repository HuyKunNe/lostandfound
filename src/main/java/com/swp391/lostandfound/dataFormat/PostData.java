package com.swp391.lostandfound.dataFormat;

import com.swp391.lostandfound.entity.Post;

import lombok.Data;

@Data
public class PostData {
    private String message;
    private Post post;
    private String status;
}
