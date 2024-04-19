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
    private int id;


    @Column(name = "user_name")
    private String userName;

    private String adress;

    @Column(name = "user_phone")
    private String phoneNumber;


    @Column(name = "user_email")
    private String email;


    @Column(name = "password")
    private String password;




}
