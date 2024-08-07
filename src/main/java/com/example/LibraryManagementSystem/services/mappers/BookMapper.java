package com.example.LibraryManagementSystem.services.mappers;

import com.example.LibraryManagementSystem.model.entities.Book;
import com.example.LibraryManagementSystem.services.dtos.requests.book.AddBookRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.book.UpdateBookRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.book.AddBookResponse;
import com.example.LibraryManagementSystem.services.dtos.responses.book.DeleteBookResponse;
import com.example.LibraryManagementSystem.services.dtos.responses.book.GetBookResponse;
import com.example.LibraryManagementSystem.services.dtos.responses.book.UpdateBookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book bookFromaddRequest(AddBookRequest request);

    @Mapping(target = "categoryName", source = "category.name")
    AddBookResponse bookFromAddResponse(Book book);

    Book bookFromUpdateRequest(UpdateBookRequest request);

    @Mapping(target = "categoryName", source = "category.name")
    UpdateBookResponse bookFromUpdateResponse(Book book);

    DeleteBookResponse bookFromDeleteResponse(Book book);

    GetBookResponse getBookidFromGetResponse(Book book);
}
