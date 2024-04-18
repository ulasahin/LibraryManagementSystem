package com.example.LibraryManagementSystem.services.mappers;

import com.example.LibraryManagementSystem.entities.Book;
import com.example.LibraryManagementSystem.entities.User;
import com.example.LibraryManagementSystem.services.dtos.requests.book.AddBookRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.book.DeleteBookRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.book.UpdateBookRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.book.AddBookResponse;
import com.example.LibraryManagementSystem.services.dtos.responses.book.DeleteBookResponse;
import com.example.LibraryManagementSystem.services.dtos.responses.book.GetBookResponse;
import com.example.LibraryManagementSystem.services.dtos.responses.book.UpdateBookResponse;
import com.example.LibraryManagementSystem.services.dtos.responses.user.GetUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book bookFromaddRequest(AddBookRequest request);

    AddBookResponse bookFromAddResponse(Book book);

    Book bookFromUpdateRequest(UpdateBookRequest request);

    UpdateBookResponse bookFromUpdateResponse(Book book);
    Book bookFromDeleteRequest(DeleteBookRequest request);

    DeleteBookResponse bookFromDeleteResponse(Book book);

    GetBookResponse getBookidFromGetResponse(Book book);
}
