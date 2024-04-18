package com.example.LibraryManagementSystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @Setter(AccessLevel.NONE)
    private int id;


    @Column(name = "user_name",length = 35, unique = true)
    private String userName;

    private String adress;

    @Column(name = "user_phone", length = 11, unique = true)
    private String phoneNumber;


    @Column(name = "user_email", unique = true, nullable = false)
    private String email;


    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Book> books;

    public User(int id) {
    }
}
