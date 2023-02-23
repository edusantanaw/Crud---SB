package com.edusantanaw.crud.auth;

import com.edusantanaw.crud.auth.DTO.SigninDTO;
import com.edusantanaw.crud.auth.DTO.SignupDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @PostMapping("/signin")
    public void signin(SigninDTO data){
    }
    @PostMapping("/signiup")
    public void signup(SignupDTO data){
    }
}
