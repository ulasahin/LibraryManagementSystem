package com.example.LibraryManagementSystem.repositories;

import com.example.LibraryManagementSystem.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
