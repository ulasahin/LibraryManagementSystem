package com.example.LibraryManagementSystem.services.mappers;

import com.example.LibraryManagementSystem.entities.Borrow;
import com.example.LibraryManagementSystem.services.dtos.requests.borrow.BorrowAddRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.borrow.BorrowAddResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BorrowMapper {
    BorrowMapper INSTANCE = Mappers.getMapper(BorrowMapper.class);


    //@Mapping(target = "book.id",source = "bookId")

    Borrow BorrowFromRequest(BorrowAddRequest request);

    @Mapping(target = "userName", source ="user.name")
    @Mapping(target = "bookName", source = "book.name")
    BorrowAddResponse BorrowFromResponse (Borrow borrow);
}
