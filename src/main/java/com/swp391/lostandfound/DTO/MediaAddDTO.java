package com.swp391.lostandfound.DTO;

import com.swp391.lostandfound.entity.Post;

import lombok.Data;

@Data
public class MediaAddDTO {

    private String link;
    private Post post;
}
