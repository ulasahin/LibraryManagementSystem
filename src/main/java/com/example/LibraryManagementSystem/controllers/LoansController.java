package com.example.LibraryManagementSystem.controllers;

import com.example.LibraryManagementSystem.entities.Loan;
import com.example.LibraryManagementSystem.services.abstracts.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loans")
@AllArgsConstructor
public class LoansController {
    private LoanService loanService;
}
