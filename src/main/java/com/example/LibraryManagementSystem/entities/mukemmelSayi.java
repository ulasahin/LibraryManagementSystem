package com.example.LibraryManagementSystem.entities;

public class mukemmelSayi {
    public static void main(String[] args) {
        System.out.println(mukemmelSayi(8129));
    }
    //mükemmel sayi kendisi hariç pozitif tam bölenlerinin kendisine eşit olan sayıdır.

    public static boolean mukemmelSayi(int a){
        int toplam = 0;
        for(int i=1;i<a;i++){
            if(a%i==0)toplam+=i;
        }
        if(toplam==a)return true;
        return false;
    }
}
