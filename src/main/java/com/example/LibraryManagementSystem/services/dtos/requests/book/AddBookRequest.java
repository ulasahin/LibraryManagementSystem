package com.example.LibraryManagementSystem.services.dtos.requests.book;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBookRequest {
    @NotBlank(message = "İsim kısmı boş olamaz.")
    @Size(min = 3,max = 200, message = "İsim alanı 3 ila 200 karakter arasında olmalıdır.")
    private String name;

    @NotBlank(message = "Yazar kısmı boş olamaz.")
    @Size(min = 3,max = 500,message = "Yazar adı alanı 3 ila 50 karakter arasında olmalıdır.")
    private String author;

    @Size(max = 200,message = "Açıklama kısmı maksimum 200 karakter olabilir.")
    private String description;
}
