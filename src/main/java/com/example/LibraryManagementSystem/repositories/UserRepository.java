package com.example.LibraryManagementSystem.repositories;

import com.example.LibraryManagementSystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

}
