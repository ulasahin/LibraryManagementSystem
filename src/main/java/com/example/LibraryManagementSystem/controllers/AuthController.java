package com.example.LibraryManagementSystem.controllers;

import com.example.LibraryManagementSystem.services.abstracts.AuthService;
import com.example.LibraryManagementSystem.services.dtos.requests.loginregister.LoginRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.loginregister.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("login")
    @ResponseStatus(HttpStatus.CREATED)
    public String login(@RequestBody LoginRequest loginRequest)
    {
        return authService.login(loginRequest);
    }
    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid RegisterRequest request) {
        authService.register(request);
    }
}
