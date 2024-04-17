package com.example.LibraryManagementSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "books")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;
    private String author;
    private String description;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private BookTypes bookTypes;

    @OneToMany(mappedBy = "book")
    private List<Loan> loans;

}
