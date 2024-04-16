package com.example.LibraryManagementSystem.repositories;

import com.example.LibraryManagementSystem.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan,Integer> {
}
