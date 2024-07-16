package com.example.LibraryManagementSystem.services.rules;

import com.example.LibraryManagementSystem.core.exceptionhandling.exception.types.BusinessException;
import com.example.LibraryManagementSystem.model.entities.Book;
import com.example.LibraryManagementSystem.model.entities.Borrow;
import com.example.LibraryManagementSystem.repositories.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class BorrowBusinesRule {
    @Autowired
    private BorrowRepository borrowRepository;

    public void setDate(Borrow borrow, LocalDate startDate, LocalDate endDate){
        borrow.setReceiptDate(startDate);
        borrow.setReturnDate(endDate);
    }

    public void deliveryDateShouldNotLate(LocalDate returnDate, LocalDate deliveryDate,Borrow borrow){

        if(returnDate.isBefore(deliveryDate)){
            long a = ChronoUnit.DAYS.between(returnDate,deliveryDate);
            borrow.getUser().setLateFee(a*5);
        }
    }

    public void bookShouldNotBorrow(Book book){
        if(book.isBorrowed()){
            throw new BusinessException("Bu kitap daha önce ödünç alındı.");
        }
    }
}
