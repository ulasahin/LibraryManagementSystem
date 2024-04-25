package com.example.LibraryManagementSystem.services.dtos.requests.borrow;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowAddRequest {
    //private LocalDate receiptDate;
    private int userId;
    private int bookId;
}
