package com.example.LibraryManagementSystem.repositories;

import com.example.LibraryManagementSystem.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByNameIgnoreCase(String name);
}
