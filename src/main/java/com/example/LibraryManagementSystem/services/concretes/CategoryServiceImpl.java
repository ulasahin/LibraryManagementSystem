package com.example.LibraryManagementSystem.services.concretes;

import com.example.LibraryManagementSystem.core.exceptionhandling.exception.types.BusinessException;
import com.example.LibraryManagementSystem.entities.Category;
import com.example.LibraryManagementSystem.repositories.CategoryRepository;
import com.example.LibraryManagementSystem.services.abstracts.CategoryService;
import com.example.LibraryManagementSystem.services.dtos.requests.category.AddCategoryRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.category.UpdateCategoryRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.category.*;
import com.example.LibraryManagementSystem.services.mappers.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findById(int id) {
       return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Böyle bir kategori bulunmamaktadır."));
    }

    @Override
    public AddCategoryResponse add(AddCategoryRequest request) {
        categoryNameWithSameNameShouldNotExist(request.getName());
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
    private void categoryNameWithSameNameShouldNotExist(String name){
        Optional<Category> categoryWithSameName = categoryRepository.findByNameIgnoreCase(name);
        if (categoryWithSameName.isPresent()){
            throw new BusinessException("Bu isim bir kategori zaten var.");
        }
    }
}
