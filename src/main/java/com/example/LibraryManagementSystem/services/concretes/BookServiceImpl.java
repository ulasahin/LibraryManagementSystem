package com.example.LibraryManagementSystem.services.concretes;

import com.example.LibraryManagementSystem.entities.Book;
import com.example.LibraryManagementSystem.services.abstracts.BookService;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public void add(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void getById(int id) {

    }

    @Override
    public List<Book> getAll() {
        return List.of();
    }
}
