package com.swp391.lostandfound.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDTO {
    private String successCode;
    private Object data;
    private String errorCode;
}
