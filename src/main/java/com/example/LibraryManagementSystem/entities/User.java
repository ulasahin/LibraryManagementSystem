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

    @NotBlank(message = "Username cannot be left blank")
    @Column(name = "user_name", nullable = false,length = 35)
    private String userName;

    private String adress;

    @Column(name = "user_phone", length = 11, unique = true)
    private String phoneNumber;

    @Column(name = "email", length = 11, unique = true)
    private String email;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Book> books;

}
