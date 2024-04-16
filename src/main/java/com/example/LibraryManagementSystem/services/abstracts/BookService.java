package com.example.LibraryManagementSystem.services.abstracts;

import com.example.LibraryManagementSystem.entities.Book;

import java.util.List;

public interface BookService {
    void add(Book book);
    void update(Book book);
    void delete(int id);
    void getById(int id);
    List<Book> getAll();
}
