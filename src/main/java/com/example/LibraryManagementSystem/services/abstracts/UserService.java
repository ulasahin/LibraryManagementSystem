package com.example.LibraryManagementSystem.services.abstracts;

import com.example.LibraryManagementSystem.entities.User;
import com.example.LibraryManagementSystem.services.dtos.requests.user.AddUserRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.user.UpdateUserRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.user.*;

import java.util.List;

public interface UserService {
    AddUserResponse add(AddUserRequest request);
    UpdateUserResponse update(UpdateUserRequest request);
    DeleteUserResponse delete(int id);
    GetUserResponse getById(int id);
    List<ListUserResponse> getAll();

    User findById(int id);
}
