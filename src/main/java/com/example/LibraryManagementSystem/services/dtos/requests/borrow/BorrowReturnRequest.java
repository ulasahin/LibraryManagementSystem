package com.example.LibraryManagementSystem.services.dtos.requests.borrow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowReturnRequest {
    private int borrowId;
}
