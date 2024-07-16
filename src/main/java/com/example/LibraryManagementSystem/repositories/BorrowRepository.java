package com.example.LibraryManagementSystem.repositories;

import com.example.LibraryManagementSystem.model.entities.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow,Integer> {
}
