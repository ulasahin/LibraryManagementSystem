package com.example.LibraryManagementSystem.services.abstracts;

import com.example.LibraryManagementSystem.services.dtos.requests.loginregister.LoginRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.loginregister.RegisterRequest;

public interface AuthService {
    void register(RegisterRequest request);
    String login(LoginRequest request);
}
