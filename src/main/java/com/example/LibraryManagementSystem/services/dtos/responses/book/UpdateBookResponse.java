package com.example.LibraryManagementSystem.services.dtos.responses.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookResponse {
    private int id;
    private String name;
    private String author;
    private String description;
    private String categoryName;
}
