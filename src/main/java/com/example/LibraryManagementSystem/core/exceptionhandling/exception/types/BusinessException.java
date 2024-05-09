package com.example.LibraryManagementSystem.core.exceptionhandling.exception.types;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
