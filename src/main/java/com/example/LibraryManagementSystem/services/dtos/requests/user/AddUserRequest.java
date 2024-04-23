package com.example.LibraryManagementSystem.services.dtos.requests.user;

import jakarta.validation.constraints.Email;
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
public class AddUserRequest {
    @NotBlank(message = "İsim kısmı boş olamaz.")
    @Size(min=3,max = 50,message = "Kullanıcı adı 3 ila 50 karakter arasında olmalı.")
    private String name;

    @NotBlank(message = "Şifre alanı boş olamaz.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z]).{6,}$"
            ,message = "Şifre en az bir numarik, en az bir tane büyük harf içermeli ve en az 6 karakter olmalıdır.")
    private String password;

    @NotBlank(message = "E-mail alanı boş olamaz.")
    @Email(message = "Geçerli bir Email değil.")
    private String email;

    @NotBlank(message = "Numara kısmı boş olamaz.")
    @Pattern(regexp= "\\d+" , message = "Sadece numarik ifadalar içermeli.")
    @Size(min = 11,max = 11, message = "Numara kısmı 11 haneli olmalı.")
    private String phoneNumber;

    @NotBlank(message = "Adres kısmı boş olamaz.")
    @Size(max = 200,message = "Adres kısmı maksimum 200 karakter olabilir.")
    private String adress;
}
