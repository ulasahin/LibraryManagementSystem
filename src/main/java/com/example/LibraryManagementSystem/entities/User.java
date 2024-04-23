package com.example.LibraryManagementSystem.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "users")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double lateFee = 0;

    private String name;

    private String address;

    private String phoneNumber;

    private String email;


    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Borrow> borrows;


}
