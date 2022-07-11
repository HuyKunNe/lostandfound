package com.swp391.lostandfound.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseDTO {
    private String firstName;
    private String lastName;
    private String studentCode;
    private String email;
    private int role;
    private String token;
}

