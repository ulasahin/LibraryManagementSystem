package com.example.LibraryManagementSystem.services.concretes;

import com.example.LibraryManagementSystem.core.utils.exception.BusinessException;
import com.example.LibraryManagementSystem.entities.Book;
import com.example.LibraryManagementSystem.entities.Borrow;
import com.example.LibraryManagementSystem.entities.User;
import com.example.LibraryManagementSystem.repositories.BorrowRepository;
import com.example.LibraryManagementSystem.repositories.UserRepository;
import com.example.LibraryManagementSystem.services.abstracts.BookService;
import com.example.LibraryManagementSystem.services.abstracts.BorrowService;
import com.example.LibraryManagementSystem.services.abstracts.UserService;
import com.example.LibraryManagementSystem.services.dtos.requests.borrow.BorrowAddRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.borrow.BorrowAddResponse;
import com.example.LibraryManagementSystem.services.mappers.BorrowMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class BorrowServiceImpl implements BorrowService {
    private BorrowRepository borrowRepository;
    private UserService userService;
    private BookService bookService;




    @Override
    public BorrowAddResponse add(BorrowAddRequest request) {
        User user = userService.findById(request.getUserId());
        Book book = bookService.findById(request.getBookId());
        if(book.isBorrowed()){
            throw new BusinessException("Bu kitap daha önce ödünç alındı.");
        }
        book.setBorrowed(true);
        Borrow borrow = BorrowMapper.INSTANCE.BorrowFromRequest(request);
        borrow.setUser(user);
        borrow.setBook(book);
        //borrow.setReceiptDate(LocalDate.now());
        //borrow.setReturnDate(LocalDate.now().plusDays(10));
        setDate(borrow,LocalDate.now(),LocalDate.now().plusDays(10));
        borrow = borrowRepository.save(borrow);
        BorrowAddResponse borrowAddResponse = BorrowMapper.INSTANCE.BorrowFromResponse(borrow);
        return borrowAddResponse;
    }
    public void setDate(Borrow borrow,LocalDate start,LocalDate end){
        borrow.setReceiptDate(start);
        borrow.setReturnDate(end);
    }
}
