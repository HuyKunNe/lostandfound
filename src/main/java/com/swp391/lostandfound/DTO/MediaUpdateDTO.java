package com.swp391.lostandfound.DTO;

import com.swp391.lostandfound.entity.Post;

import lombok.Data;

@Data
public class MediaUpdateDTO {
    private String link;
    private int status;
    private int postId;
}
