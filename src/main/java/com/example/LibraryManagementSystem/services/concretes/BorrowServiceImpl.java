package com.example.LibraryManagementSystem.services.concretes;

import com.example.LibraryManagementSystem.core.exceptionhandling.exception.types.BusinessException;
import com.example.LibraryManagementSystem.model.entities.Book;
import com.example.LibraryManagementSystem.model.entities.Borrow;
import com.example.LibraryManagementSystem.model.enums.BorrowStatus;
import com.example.LibraryManagementSystem.model.entities.User;
import com.example.LibraryManagementSystem.repositories.BorrowRepository;
import com.example.LibraryManagementSystem.services.abstracts.BookService;
import com.example.LibraryManagementSystem.services.abstracts.BorrowService;
import com.example.LibraryManagementSystem.services.abstracts.UserService;
import com.example.LibraryManagementSystem.services.dtos.requests.borrow.BorrowAddRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.borrow.BorrowReturnRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.borrow.*;
import com.example.LibraryManagementSystem.services.mappers.BorrowMapper;
import com.example.LibraryManagementSystem.services.rules.BorrowBusinesRule;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
public class BorrowServiceImpl implements BorrowService {
    private BorrowRepository borrowRepository;
    private UserService userService;
    private BookService bookService;
    @Autowired
    private BorrowBusinesRule borrowBusinesRule;

    @Override
    public BorrowAddResponse add(BorrowAddRequest request) {
        User user = userService.findById(request.getUserId());
        Book book = bookService.findById(request.getBookId());
        borrowBusinesRule.bookShouldNotBorrow(book);
        book.setBorrowed(true);
        Borrow borrow = BorrowMapper.INSTANCE.borrowFromAddRequest(request);
        borrow.setUser(user);
        borrow.setBook(book);
        //borrow.setReceiptDate(LocalDate.now());
        //borrow.setReturnDate(LocalDate.now().plusDays(10));
        borrowBusinesRule.setDate(borrow,LocalDate.now(),LocalDate.now().plusDays(10));
        borrow = borrowRepository.save(borrow);
        BorrowAddResponse borrowAddResponse = BorrowMapper.INSTANCE.borrowFromAddResponse(borrow);
        return borrowAddResponse;
    }

    @Override
    public BorrowReturnResponse returnBook(BorrowReturnRequest request) {
        Borrow borrow = borrowRepository.findById(request.getBorrowId()).orElseThrow(()
                -> new BusinessException("Böyle bir ödünç alma işlemi yok."));
        Borrow borrow1 = BorrowMapper.INSTANCE.borrowFromReturnRequest(request);
        borrow1.setReceiptDate(borrow.getReceiptDate());
        borrow1.setReturnDate(borrow.getReturnDate());
        borrow1.setBook(borrow.getBook());
        borrow1.setUser(borrow.getUser());
        borrow1.setDeliveryDate(LocalDate.now());
        borrow1.setBorrowStatus(BorrowStatus.RETURNED);
        borrow1.getBook().setBorrowed(false);
        borrowBusinesRule.deliveryDateShouldNotLate(borrow.getReturnDate(),LocalDate.now(),borrow1);
        borrow1 = borrowRepository.save(borrow1);
        BorrowReturnResponse borrowReturnResponse = BorrowMapper.INSTANCE.borrowFromReturnResponse(borrow1);
        return borrowReturnResponse;
    }

    @Override
    public DeleteBorrowResponse delete(int id) {
        Borrow borrow = borrowRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Böyle bir ödünç alım bulunamadı."));
        DeleteBorrowResponse deleteBorrowResponse = BorrowMapper.INSTANCE.borrowFromDeleteResponse(borrow);
        borrowRepository.delete(borrow);
        return deleteBorrowResponse;
    }

    @Override
    public GetBorrowResponse getById(int id) {
        Borrow borrow = borrowRepository.findById(id)
                .orElseThrow(()-> new BusinessException("Böyle bir ödünç alım bulunamadı."));
        GetBorrowResponse getBorrowResponse = BorrowMapper.INSTANCE.borrowFromGetResponse(borrow);
        return getBorrowResponse;
    }

    @Override
    public List<ListBorrowResponse> getAll() {
        List<Borrow> borrow = borrowRepository.findAll();

        return borrow.stream().map(b -> new ListBorrowResponse(b.getId()
                ,b.getUser().getName()
                ,b.getBook().getName())).toList();
    }
}
