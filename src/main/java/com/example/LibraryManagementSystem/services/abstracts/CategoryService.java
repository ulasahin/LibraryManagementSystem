package com.example.LibraryManagementSystem.services.abstracts;

import com.example.LibraryManagementSystem.model.entities.Category;
import com.example.LibraryManagementSystem.services.dtos.requests.category.AddCategoryRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.category.UpdateCategoryRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.category.*;

import java.util.List;

public interface CategoryService {
    Category findById(int id);
    AddCategoryResponse add(AddCategoryRequest request);
    UpdateCategoryResponse update(UpdateCategoryRequest request);
    DeleteCategoryResponse delete(int id);
    GetCategoryResponse getById(int id);
    List<ListCategoryResponse> getAll();
}
