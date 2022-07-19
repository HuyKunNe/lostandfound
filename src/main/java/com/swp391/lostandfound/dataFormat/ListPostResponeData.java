package com.swp391.lostandfound.dataFormat;

import java.util.List;

import com.swp391.lostandfound.DTO.responseDTO.PostResponseDTO;

import lombok.Data;

@Data
public class ListPostResponeData {
    private String message;
    private List<PostResponseDTO> data;
    private String status;
}
