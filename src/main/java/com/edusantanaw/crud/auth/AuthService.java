package com.edusantanaw.crud.auth;

import com.edusantanaw.crud.auth.DTO.SigninDTO;
import com.edusantanaw.crud.auth.DTO.SignupDTO;
import com.edusantanaw.crud.config.security.JwtService;
import com.edusantanaw.crud.infra.UserRepository;
import com.edusantanaw.crud.user.entity.Roles;
import com.edusantanaw.crud.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse auth(SigninDTO data){
        authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
                       data.getEmail(),
                       data.getPassword()
               )
        );
        var user = repository.findByEmail(data.getEmail()).orElseThrow();
        var token = jwtService.generateToken(user);
        return  AuthResponse.
                builder()
                .token(token)
                .user(user)
                .build();
    }
    public AuthResponse create(SignupDTO data){
        var user =  User
                .builder()
                .firstname(data.getFirstname())
                .lastname(data.getLastname())
                .email(data.getEmail())
                .password(passwordEncoder.encode(data.getPassword()))
                .role(Roles.USER)
                .build();
        repository.save(user);
        var jwt = jwtService.generateToken( user);
        return  AuthResponse.builder()
                .token(jwt)
                .user(user)
                .build();
    }
}

