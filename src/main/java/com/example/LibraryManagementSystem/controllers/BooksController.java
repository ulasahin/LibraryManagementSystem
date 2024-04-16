package com.example.LibraryManagementSystem.controllers;

import com.example.LibraryManagementSystem.services.abstracts.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BooksController {
    private BookService bookService;

}
