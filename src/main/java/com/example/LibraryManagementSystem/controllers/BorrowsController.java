package com.example.LibraryManagementSystem.controllers;

import com.example.LibraryManagementSystem.services.abstracts.BorrowService;
import com.example.LibraryManagementSystem.services.dtos.requests.borrow.BorrowAddRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.borrow.BorrowReturnRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.borrow.BorrowAddResponse;
import com.example.LibraryManagementSystem.services.dtos.responses.borrow.BorrowReturnResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrows")
@AllArgsConstructor
public class BorrowsController {
    private BorrowService borrowService;
    @PostMapping
    public BorrowAddResponse add(@RequestBody BorrowAddRequest request){
       return borrowService.add(request);
    }
    @PutMapping
    public BorrowReturnResponse returnBook(@RequestBody BorrowReturnRequest request){
        return borrowService.returnBook(request);
    }
}
