package com.example.LibraryManagementSystem.services.dtos.responses.borrow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListBorrowResponse {
    private int id;
    private String userName;
    private String bookName;
}
