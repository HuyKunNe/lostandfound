package com.swp391.lostandfound.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserAddDTO {
    private String firstName;
    private String lastName;
    private String birthday;
    private String gender;
    private String studentCode;
    private String email;
    private String phoneNumber;
    private String password;
}
