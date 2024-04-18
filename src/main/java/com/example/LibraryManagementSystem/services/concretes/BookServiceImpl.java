package com.example.LibraryManagementSystem.services.concretes;

import com.example.LibraryManagementSystem.entities.Book;
import com.example.LibraryManagementSystem.repositories.BookRepository;
import com.example.LibraryManagementSystem.services.abstracts.BookService;
import com.example.LibraryManagementSystem.services.dtos.requests.book.AddBookRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.book.DeleteBookRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.book.UpdateBookRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.book.*;
import com.example.LibraryManagementSystem.services.mappers.BookMapper;
import com.example.LibraryManagementSystem.services.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;


    @Override
    public AddBookResponse add(AddBookRequest request) {
        Book book =BookMapper.INSTANCE.bookFromaddRequest(request);
        book = bookRepository.save(book);
        AddBookResponse addBookResponse = BookMapper.INSTANCE.bookFromAddResponse(book);
        return addBookResponse;
    }

    @Override
    public UpdateBookResponse update(UpdateBookRequest request) {
        Book book =BookMapper.INSTANCE.bookFromUpdateRequest(request);
        book = bookRepository.save(book);
        UpdateBookResponse updateBookResponse = BookMapper.INSTANCE.bookFromUpdateResponse(book);
        return updateBookResponse;
    }

    @Override
    public DeleteBookResponse delete(DeleteBookRequest request) {
        Book book = BookMapper.INSTANCE.bookFromDeleteRequest(request);
        bookRepository.delete(book);
        DeleteBookResponse deleteBookResponse = BookMapper.INSTANCE.bookFromDeleteResponse(book);
        return deleteBookResponse;
    }

    @Override
    public GetBookResponse getById(int id) {
        Book book = bookRepository.findById(id).orElseThrow();
        GetBookResponse getBookResponse = BookMapper.INSTANCE.getBookResponseFromBook(book);
        return getBookResponse;
    }

    @Override
    public List<ListBookResponse> getAll() {
       List<Book> books = bookRepository.findAll();
      return books.stream().map(b -> new ListBookResponse(b.getId(),b.getName(),
              b.getAuthor(),b.getDescription())).toList();


    }
}

