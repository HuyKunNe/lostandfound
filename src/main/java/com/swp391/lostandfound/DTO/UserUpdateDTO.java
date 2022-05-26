package com.swp391.lostandfound.DTO;

import lombok.Data;

@Data
public class UserUpdateDTO {

    private String firstName;
    private String lastName;
    private String birthday;
    private String gender;
    private String studentCode;
    private String email;
    private String phoneNumber;
    private int status;
}
