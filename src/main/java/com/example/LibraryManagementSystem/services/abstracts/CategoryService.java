package com.example.LibraryManagementSystem.services.abstracts;

import com.example.LibraryManagementSystem.entities.Category;
import com.example.LibraryManagementSystem.repositories.CategoryRepository;

import java.util.Optional;

public interface CategoryService {
    Category findById(int id);
}
