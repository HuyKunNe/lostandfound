package com.swp391.lostandfound.DTO;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticateDTO {

    @NotBlank
    private String studentCode;
    @NotBlank
    private String password;
}
