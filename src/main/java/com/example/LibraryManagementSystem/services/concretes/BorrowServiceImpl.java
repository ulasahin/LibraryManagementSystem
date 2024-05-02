package com.example.LibraryManagementSystem.services.concretes;

import com.example.LibraryManagementSystem.core.utils.exception.types.BusinessException;
import com.example.LibraryManagementSystem.entities.Book;
import com.example.LibraryManagementSystem.entities.Borrow;
import com.example.LibraryManagementSystem.entities.BorrowStatus;
import com.example.LibraryManagementSystem.entities.User;
import com.example.LibraryManagementSystem.repositories.BorrowRepository;
import com.example.LibraryManagementSystem.services.abstracts.BookService;
import com.example.LibraryManagementSystem.services.abstracts.BorrowService;
import com.example.LibraryManagementSystem.services.abstracts.UserService;
import com.example.LibraryManagementSystem.services.dtos.requests.borrow.BorrowAddRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.borrow.BorrowReturnRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.borrow.*;
import com.example.LibraryManagementSystem.services.mappers.BorrowMapper;
import lombok.AllArgsConstructor;
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

    @Override
    public BorrowAddResponse add(BorrowAddRequest request) {
        User user = userService.findById(request.getUserId());
        Book book = bookService.findById(request.getBookId());
        bookShouldNotBorrow(book);
        book.setBorrowed(true);
        Borrow borrow = BorrowMapper.INSTANCE.borrowFromAddRequest(request);
        borrow.setUser(user);
        borrow.setBook(book);
        //borrow.setReceiptDate(LocalDate.now());
        //borrow.setReturnDate(LocalDate.now().plusDays(10));
        setDate(borrow,LocalDate.now(),LocalDate.now().plusDays(10));
        borrow = borrowRepository.save(borrow);
        BorrowAddResponse borrowAddResponse = BorrowMapper.INSTANCE.borrowFromAddResponse(borrow);
        return borrowAddResponse;
    }

    @Override
    public BorrowReturnResponse returnBook(BorrowReturnRequest request) {
        Borrow borrow = borrowRepository.findById(request.getBorrowId()).orElseThrow(() -> new BusinessException("Böyle bir ödünç alma işlemi yok."));
        Borrow borrow1 = BorrowMapper.INSTANCE.borrowFromReturnRequest(request);
        borrow1.setReceiptDate(borrow.getReceiptDate());
        borrow1.setReturnDate(borrow.getReturnDate());
        borrow1.setBook(borrow.getBook());
        borrow1.setUser(borrow.getUser());
        borrow1.setDeliveryDate(LocalDate.now());
        borrow1.setBorrowStatus(BorrowStatus.RETURNED);
        borrow1.getBook().setBorrowed(false);
        deliveryDateShouldNotLate(borrow.getReturnDate(),LocalDate.now(),borrow1);
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
    //Business Rules
    public void setDate(Borrow borrow,LocalDate startDate,LocalDate endDate){
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
