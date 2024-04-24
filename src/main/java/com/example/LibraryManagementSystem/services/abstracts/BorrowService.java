package com.example.LibraryManagementSystem.services.abstracts;

import com.example.LibraryManagementSystem.entities.Book;
import com.example.LibraryManagementSystem.entities.Borrow;
import com.example.LibraryManagementSystem.services.dtos.requests.borrow.BorrowAddRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.borrow.BorrowReturnRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.borrow.BorrowAddResponse;
import com.example.LibraryManagementSystem.services.dtos.responses.borrow.BorrowReturnResponse;

import java.util.List;

public interface BorrowService {

    BorrowAddResponse add(BorrowAddRequest request);
    BorrowReturnResponse returnBook(BorrowReturnRequest request);
}
