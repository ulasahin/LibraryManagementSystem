package com.example.LibraryManagementSystem.services.dtos.responses.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserResponse {
    private int id;
    private String userName;
    private String email;
}
