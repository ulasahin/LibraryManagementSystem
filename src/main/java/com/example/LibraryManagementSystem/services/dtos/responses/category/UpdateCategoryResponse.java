package com.example.LibraryManagementSystem.services.dtos.responses.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryResponse {
    private int id;
    private String name;
}
