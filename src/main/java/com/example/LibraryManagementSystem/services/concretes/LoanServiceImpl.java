package com.example.LibraryManagementSystem.services.concretes;

import com.example.LibraryManagementSystem.entities.Book;
import com.example.LibraryManagementSystem.entities.Loan;
import com.example.LibraryManagementSystem.services.abstracts.LoanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
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
}
