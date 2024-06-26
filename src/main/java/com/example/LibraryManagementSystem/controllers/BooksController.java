package com.example.LibraryManagementSystem.controllers;

import com.example.LibraryManagementSystem.services.abstracts.BookService;
import com.example.LibraryManagementSystem.services.dtos.requests.book.AddBookRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.book.UpdateBookRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.book.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BooksController {
    private BookService bookService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ListBookResponse> getAll(){
        return bookService.getAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddBookResponse add(@RequestBody @Valid AddBookRequest request){
        return bookService.add(request);}
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdateBookResponse update(@RequestBody @Valid UpdateBookRequest request){return bookService.update(request);}
    @DeleteMapping
    public DeleteBookResponse delete(@RequestParam int id){return bookService.delete(id);}
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetBookResponse getById(@RequestParam int id){
        return bookService.getById(id);
    }
}
