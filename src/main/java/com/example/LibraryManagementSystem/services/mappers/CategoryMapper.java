package com.example.LibraryManagementSystem.services.mappers;

import com.example.LibraryManagementSystem.model.entities.Category;
import com.example.LibraryManagementSystem.services.dtos.requests.category.AddCategoryRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.category.UpdateCategoryRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.category.AddCategoryResponse;
import com.example.LibraryManagementSystem.services.dtos.responses.category.DeleteCategoryResponse;
import com.example.LibraryManagementSystem.services.dtos.responses.category.GetCategoryResponse;
import com.example.LibraryManagementSystem.services.dtos.responses.category.UpdateCategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category categoryFromAddRequest(AddCategoryRequest request);
    AddCategoryResponse categoryFromAddResponse(Category category);

    Category categoryFromUpdateRequest(UpdateCategoryRequest request);
    UpdateCategoryResponse categoryFromUpdateResponse(Category category);

    DeleteCategoryResponse categoryFromDeleteResponse(Category category);

    GetCategoryResponse categoryFromGetResponse(Category category);
}
