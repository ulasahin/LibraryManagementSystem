package com.example.LibraryManagementSystem.controllers;

import com.example.LibraryManagementSystem.services.abstracts.BookService;
import com.example.LibraryManagementSystem.services.dtos.requests.book.AddBookRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.book.UpdateBookRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.book.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BooksController {
    private BookService bookService;
    @GetMapping
    public List<ListBookResponse> getAll(){
        return bookService.getAll();
    }
    @PostMapping
    public AddBookResponse add(@RequestBody AddBookRequest request){
        return bookService.add(request);
    }
    @PutMapping
    public UpdateBookResponse update(@RequestBody UpdateBookRequest request){
        return bookService.update(request);
    }
    @DeleteMapping
    public DeleteBookResponse delete(@RequestParam int id){
        return bookService.delete(id);
    }
    @GetMapping(value = "/{id}")
    public GetBookResponse getById(@RequestParam int id){
        return bookService.getById(id);
    }
}
