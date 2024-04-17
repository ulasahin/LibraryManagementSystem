package com.example.LibraryManagementSystem.services.abstracts;

import com.example.LibraryManagementSystem.entities.Book;
import com.example.LibraryManagementSystem.entities.User;
import com.example.LibraryManagementSystem.services.dtos.requests.user.AddUserRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.user.AddUserResponse;

import java.util.List;

public interface UserService {
    AddUserResponse add(AddUserRequest request);
    void update(User user);
    void delete(int id);
    void getById(int id);
    List<User> getAll();
}
