package com.swp391.lostandfound.dataFormat;

import java.util.List;

import com.swp391.lostandfound.entity.Media;

import lombok.Data;

@Data
public class ListMedias {

    private String message;
    private List<Media> data;
    private String status;
}
