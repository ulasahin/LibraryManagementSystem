package com.example.LibraryManagementSystem.controllers;

import com.example.LibraryManagementSystem.services.abstracts.BorrowService;
import com.example.LibraryManagementSystem.services.dtos.requests.borrow.BorrowAddRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.borrow.BorrowReturnRequest;
import com.example.LibraryManagementSystem.services.dtos.responses.borrow.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrows")
@AllArgsConstructor
public class BorrowsController {
    private BorrowService borrowService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BorrowAddResponse add(@RequestBody @Valid BorrowAddRequest request){return borrowService.add(request);}
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public BorrowReturnResponse returnBook(@RequestBody @Valid BorrowReturnRequest request){return borrowService.returnBook(request);}
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public DeleteBorrowResponse delete(@RequestParam int id){
        return borrowService.delete(id);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ListBorrowResponse> getAll(){
        return borrowService.getAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetBorrowResponse getById(int id){return borrowService.getById(id);}
}
