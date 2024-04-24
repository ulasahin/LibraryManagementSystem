package com.example.LibraryManagementSystem.services.dtos.requests.book;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookRequest {
    private int id;

    @Size(min = 0,max = 200)
    private String name;

    @Size(min = 0,max = 200)
    private String author;

    @Size(min = 0,max = 200)
    private String description;
}
