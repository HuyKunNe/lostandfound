package com.swp391.lostandfound.DTO;

import java.util.List;

import lombok.Data;

@Data
public class MediaUpdateDTO {
    private List<String> link;
    private int status;
    private int postId;
}
