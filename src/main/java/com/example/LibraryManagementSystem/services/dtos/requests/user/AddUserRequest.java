package com.example.LibraryManagementSystem.services.dtos.requests.user;

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
    private String userName;

    @NotBlank(message = "Şifre alanı boş olamaz.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z]).{6,}$"
            ,message = "Şifre en az bir numarik, en az bir tane büyük harf içermeli ve en az 6 karakter olmalıdır.")
    private String password;

    @NotBlank(message = "E-mail alanı boş olamaz.")
    private String email;

    //@Pattern(regexp="\\s*\\d{11,}\\s*") yapısı çalışmassa başına ve sonuna \n eklenmeli.
    @Pattern(regexp="\\s*\\d{11,}\\s*" , message = "Numara 11 haneli olmalı.")
    private String phoneNumber;

    @Size(min = 10,max = 300)
    private String adress;
}
