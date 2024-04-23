package com.example.LibraryManagementSystem.services.abstracts;

import com.example.LibraryManagementSystem.entities.Book;
import com.example.LibraryManagementSystem.services.dtos.requests.book.AddBookRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.book.UpdateBookRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.user.UpdateUserRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.book.*;

import java.util.List;

public interface BookService {
   AddBookResponse add(AddBookRequest request);
   List<ListBookResponse> getAll();

   UpdateBookResponse update(UpdateBookRequest request);
   DeleteBookResponse delete(int id);

   GetBookResponse getById(int id);

   Book findById(int id);
}

