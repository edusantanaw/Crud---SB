package com.edusantanaw.crud.auth;

import com.edusantanaw.crud.config.security.UserDetailsIpl;
import com.edusantanaw.crud.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private UserDetails user;
}
