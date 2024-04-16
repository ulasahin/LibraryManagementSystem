package com.example.LibraryManagementSystem.services.abstracts;

import com.example.LibraryManagementSystem.entities.Book;
import com.example.LibraryManagementSystem.entities.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void update(User user);
    void delete(int id);
    void getById(int id);
    List<Book> getAll();
}
