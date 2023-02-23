package com.edusantanaw.crud.auth.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class SigninDTO {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(max = 15, min = 5)
    private String password;
}
