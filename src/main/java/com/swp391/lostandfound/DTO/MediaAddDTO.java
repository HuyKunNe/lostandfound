package com.swp391.lostandfound.DTO;

import java.util.List;

import lombok.Data;

@Data
public class MediaAddDTO {

    private List<String> link;
    private int postId;
}
