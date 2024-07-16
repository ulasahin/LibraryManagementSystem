package com.example.LibraryManagementSystem.services.mappers;

import com.example.LibraryManagementSystem.model.entities.Borrow;
import com.example.LibraryManagementSystem.services.dtos.requests.borrow.BorrowAddRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.borrow.BorrowReturnRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.borrow.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BorrowMapper {
    BorrowMapper INSTANCE = Mappers.getMapper(BorrowMapper.class);

    //@Mapping(target = "book.id",source = "bookId")

    Borrow borrowFromAddRequest(BorrowAddRequest request);

    @Mapping(target = "userName", source ="user.name")
    @Mapping(target = "bookName", source = "book.name")
    BorrowAddResponse borrowFromAddResponse (Borrow borrow);

    @Mapping(target = "id",source = "borrowId")
    Borrow borrowFromReturnRequest(BorrowReturnRequest request);

    @Mapping(target = "userLateFee",source = "user.lateFee")
    @Mapping(target = "userName",source = "user.name")
    @Mapping(target = "bookName",source = "book.name")
    BorrowReturnResponse borrowFromReturnResponse(Borrow borrow);

    DeleteBorrowResponse borrowFromDeleteResponse(Borrow borrow);

    @Mapping(target = "userName",source = "user.name")
    @Mapping(target = "bookName",source = "book.name")
    GetBorrowResponse borrowFromGetResponse(Borrow borrow);

}
