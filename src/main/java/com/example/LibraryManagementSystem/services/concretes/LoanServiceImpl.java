package com.example.LibraryManagementSystem.services.concretes;

import com.example.LibraryManagementSystem.entities.Book;
import com.example.LibraryManagementSystem.entities.Loan;
import com.example.LibraryManagementSystem.repositories.LoanRepository;
import com.example.LibraryManagementSystem.services.abstracts.LoanService;
import com.example.LibraryManagementSystem.services.dtos.requests.book.BorrowBookRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.book.BorrowBookResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements LoanService {
    private LoanRepository loanRepository;

    @Override
    public void add(Loan loan) {

    }

    @Override
    public void update(Loan loan) {

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

    @Override
    public BorrowBookResponse borrowBook(BorrowBookRequest request) {

    }
}
