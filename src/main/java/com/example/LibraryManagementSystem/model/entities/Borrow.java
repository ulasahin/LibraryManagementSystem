package com.example.LibraryManagementSystem.model.entities;

import com.example.LibraryManagementSystem.model.enums.BorrowStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "borrows")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@Column(name = "issue_date")
    //private LocalDate delivery_date;
    private LocalDate receiptDate;
    private LocalDate returnDate;
    private LocalDate deliveryDate;

    @Enumerated(EnumType.STRING)
    private BorrowStatus borrowStatus = BorrowStatus.BORROWED;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
