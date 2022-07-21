package com.swp391.lostandfound.dataFormat;

import com.swp391.lostandfound.DTO.responseDTO.LostPostReponseDTO;

import lombok.Data;

@Data
public class LostPostReponseData {
    private String message;
    private LostPostReponseDTO data;
    private String status;
}
