package com.example.LibraryManagementSystem.services.mappers;

import com.example.LibraryManagementSystem.entities.Loan;
import com.example.LibraryManagementSystem.services.dtos.requests.book.BorrowBookRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.book.BorrowBookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LoanMapper {
    LoanMapper INSTANCE = Mappers.getMapper(LoanMapper.class);
    Loan loanBorrowFromRequest(BorrowBookRequest request);

    BorrowBookResponse loanBorrowFromResponse (Loan loan);
}
