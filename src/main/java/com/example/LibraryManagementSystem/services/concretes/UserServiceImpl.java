package com.example.LibraryManagementSystem.services.concretes;

import com.example.LibraryManagementSystem.entities.Book;
import com.example.LibraryManagementSystem.entities.User;
import com.example.LibraryManagementSystem.repositories.UserRepository;
import com.example.LibraryManagementSystem.services.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public void add(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void getById(int id) {

    }

    @Override
    public List<Book> getAll() {
        return List.of();
    }
}
