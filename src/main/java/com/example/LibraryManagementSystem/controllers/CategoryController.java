package com.example.LibraryManagementSystem.controllers;

import com.example.LibraryManagementSystem.services.abstracts.CategoryService;
import com.example.LibraryManagementSystem.services.dtos.requests.category.AddCategoryRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.category.UpdateCategoryRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.category.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;
    @PostMapping
    public AddCategoryResponse add(@RequestBody @Valid AddCategoryRequest request){
        return categoryService.add(request);
    }
    @PutMapping
    public UpdateCategoryResponse update(@RequestBody @Valid UpdateCategoryRequest request){
        return categoryService.update(request);
    }
    @DeleteMapping
    public DeleteCategoryResponse delete(@RequestParam int id){
        return categoryService.delete(id);
    }
    @GetMapping
    public List<ListCategoryResponse> getAll(){
        return categoryService.getAll();
    }
    @GetMapping(value = "/{id}")
    public GetCategoryResponse getById(int id){
        return categoryService.getById(id);
    }
}
