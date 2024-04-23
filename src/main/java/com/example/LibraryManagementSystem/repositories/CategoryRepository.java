package com.example.LibraryManagementSystem.repositories;

import com.example.LibraryManagementSystem.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
