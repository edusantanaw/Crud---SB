package com.edusantanaw.crud.auth.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class SignupDTO {

    @NotBlank
    @Size(min = 2, max = 20)
    private String firstname;
    @NotBlank
    @Size(min = 2, max = 20)
    private String lastname;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 5, max = 15)
    private String password;
    @NotBlank
    @Size(min = 5, max = 15)
    private String confirmPassword;
}
