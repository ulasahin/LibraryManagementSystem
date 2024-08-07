package com.example.LibraryManagementSystem.services.concretes;

import com.example.LibraryManagementSystem.core.exceptionhandling.exception.types.BusinessException;
import com.example.LibraryManagementSystem.model.entities.Category;
import com.example.LibraryManagementSystem.repositories.CategoryRepository;
import com.example.LibraryManagementSystem.services.abstracts.CategoryService;
import com.example.LibraryManagementSystem.services.dtos.requests.category.AddCategoryRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.category.UpdateCategoryRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.category.*;
import com.example.LibraryManagementSystem.services.mappers.CategoryMapper;
import com.example.LibraryManagementSystem.services.rules.CategoryBusinessRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryBusinessRule categoryBusinessRule;

    @Override
    public Category findById(int id) {
       return categoryRepository.findById(id).orElseThrow(() -> new BusinessException("Böyle bir kategori bulunmamaktadır."));
    }

    @Override
    public AddCategoryResponse add(AddCategoryRequest request) {
        categoryBusinessRule.categoryNameWithSameNameShouldNotExist(request.getName());
        Category category = CategoryMapper.INSTANCE.categoryFromAddRequest(request);
        category = categoryRepository.save(category);
        AddCategoryResponse addCategoryResponse = CategoryMapper.INSTANCE.categoryFromAddResponse(category);
        return addCategoryResponse;
    }

    @Override
    public UpdateCategoryResponse update(UpdateCategoryRequest request) {
        Category category = CategoryMapper.INSTANCE.categoryFromUpdateRequest(request);
        category = categoryRepository.save(category);
        UpdateCategoryResponse updateCategoryResponse = CategoryMapper.INSTANCE.categoryFromUpdateResponse(category);
        return updateCategoryResponse;
    }

    @Override
    public DeleteCategoryResponse delete(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new BusinessException("Böyle bir ID'ye sahip kategori bulunamadı."));
        DeleteCategoryResponse deleteCategoryResponse = CategoryMapper.INSTANCE.categoryFromDeleteResponse(category);
        categoryRepository.delete(category);
        return deleteCategoryResponse;
    }

    @Override
    public GetCategoryResponse getById(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new BusinessException("Böyle bir ID'ye sahip kategori bulunamadı."));
        GetCategoryResponse getCategoryResponse = CategoryMapper.INSTANCE.categoryFromGetResponse(category);
        return getCategoryResponse;
    }

    @Override
    public List<ListCategoryResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(c-> new ListCategoryResponse(c.getId(),c.getName())).toList();
    }

}
