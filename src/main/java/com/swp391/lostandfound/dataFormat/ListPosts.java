package com.swp391.lostandfound.dataFormat;

import java.util.List;

import com.swp391.lostandfound.entity.Post;

import lombok.Data;

@Data
public class ListPosts {
    private String message;
    private List<Post> data;
    private String status;
}
