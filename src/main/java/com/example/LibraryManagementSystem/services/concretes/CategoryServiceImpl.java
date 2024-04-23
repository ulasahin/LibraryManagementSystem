package com.example.LibraryManagementSystem.services.concretes;

import com.example.LibraryManagementSystem.entities.Category;
import com.example.LibraryManagementSystem.repositories.CategoryRepository;
import com.example.LibraryManagementSystem.services.abstracts.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findById(int id) {
       return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("böyle bir kategori bulunmamaktadır."));
    }
}
