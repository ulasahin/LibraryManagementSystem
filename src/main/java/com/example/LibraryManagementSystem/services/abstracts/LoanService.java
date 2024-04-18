package com.example.LibraryManagementSystem.services.abstracts;

import com.example.LibraryManagementSystem.entities.Book;
import com.example.LibraryManagementSystem.entities.Loan;
import com.example.LibraryManagementSystem.services.dtos.requests.book.BorrowBookRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.book.BorrowBookResponse;

import java.util.List;

public interface LoanService {
    void add(Loan loan);
    void update(Loan loan);
    void delete(int id);
    void getById(int id);
    List<Book> getAll();
    BorrowBookResponse borrowBook(BorrowBookRequest request);
}
