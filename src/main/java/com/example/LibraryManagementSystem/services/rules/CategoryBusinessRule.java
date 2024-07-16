package com.example.LibraryManagementSystem.services.rules;

import com.example.LibraryManagementSystem.core.exceptionhandling.exception.types.BusinessException;
import com.example.LibraryManagementSystem.model.entities.Category;
import com.example.LibraryManagementSystem.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryBusinessRule {
    @Autowired
    private CategoryRepository categoryRepository;

    public void categoryNameWithSameNameShouldNotExist(String name){
        Optional<Category> categoryWithSameName = categoryRepository.findByNameIgnoreCase(name);
        if (categoryWithSameName.isPresent()){
            throw new BusinessException("Bu isim bir kategori zaten var.");
        }
    }
}
