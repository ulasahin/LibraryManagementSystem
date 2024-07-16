package com.example.LibraryManagementSystem.services.rules;

import com.example.LibraryManagementSystem.core.exceptionhandling.exception.types.BusinessException;
import com.example.LibraryManagementSystem.model.entities.User;
import com.example.LibraryManagementSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserBusinessRule {
    @Autowired
    private UserRepository userRepository;

    public void userNameWithSameNameShouldNotExist(String name){
        Optional<User> userWithSameName = userRepository.findByNameIgnoreCase(name);
        if (userWithSameName.isPresent()){
            throw new BusinessException("Bu isimde bir kullanıcı zaten var.");
        }
    }
}
