package com.example.LibraryManagementSystem.repositories;

import com.example.LibraryManagementSystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
