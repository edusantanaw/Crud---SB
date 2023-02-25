package com.edusantanaw.crud.auth;

import com.edusantanaw.crud.auth.DTO.SigninDTO;
import com.edusantanaw.crud.auth.DTO.SignupDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody @Valid SigninDTO data){
        AuthResponse auth = authService.auth(data);
        return ResponseEntity.ok(auth);
    }

    public ResponseEntity<AuthResponse> signup(@RequestBody @Valid  SignupDTO data){
        System.out.println("test");
        AuthResponse auth = authService.create(data);
        return ResponseEntity.ok(auth);
    }
}
