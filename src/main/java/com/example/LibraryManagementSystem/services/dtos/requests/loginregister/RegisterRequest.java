package com.example.LibraryManagementSystem.services.dtos.requests.loginregister;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String passwordConfirm;
    private String address;
    private String phoneNumber;
}
