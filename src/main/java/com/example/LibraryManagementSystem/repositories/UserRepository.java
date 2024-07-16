package com.example.LibraryManagementSystem.repositories;

import com.example.LibraryManagementSystem.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByNameIgnoreCase(String name);
    Optional<User> findByEmail(String email);
}
