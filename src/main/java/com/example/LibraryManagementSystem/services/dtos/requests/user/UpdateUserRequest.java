package com.example.LibraryManagementSystem.services.dtos.requests.user;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    private int id;

    @Size(min=0,max = 50,message = "Kullanıcı adı 3 ila 50 karakter arasında olmalı.")
    private String name;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z]).{6,}$"
            ,message = "Şifre en az bir numarik, en az bir tane büyük harf içermeli ve en az 6 karakter olmalıdır.")
    @Size(min = 0)
    private String password;

    @Size(min = 0)
    @Email(message = "Geçerli bir Email değil.")
    private String email;


    @Pattern(regexp= "^(?:\\d{11}|\\d{0})$" , message = "Sadece numarik ifadeler içermeli.")
    @Size(min = 0,max = 11,message = "Numara kısmı 11 haneli olmalı.")
    private String phoneNumber;

    
    @Size(min = 0,max = 200,message = "Adres kısmı maksimum 200 karakter olabilir.")
    private String adress;
}
