package com.swp391.lostandfound.dataFormat;

import com.swp391.lostandfound.entity.Media;

import lombok.Data;

@Data
public class MediaData {
    private String message;
    private Media media;
    private String status;
}
