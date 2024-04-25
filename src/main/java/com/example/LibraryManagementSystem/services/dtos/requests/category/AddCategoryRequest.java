package com.example.LibraryManagementSystem.services.dtos.requests.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCategoryRequest {
    @NotBlank(message = "İsim kısmı boş olamaz.")
    @Size(min = 3,max = 50, message = "İsim kısmı 3 ila 50 karakter aralığında olabilir.")
    @Pattern(regexp = "^[^0-9]*$",message = "İsim kısmı numerik ifade alamaz.")
    private String name;
}
