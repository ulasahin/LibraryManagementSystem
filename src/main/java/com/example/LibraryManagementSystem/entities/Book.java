package com.example.LibraryManagementSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "books")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    private String author;
    private String description;
    private boolean isBorrowed=false;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "book")
    private List<Borrow> borrowList;

    // Cascade
    //REMOVE -> bir entity silinirse, ona bağlı entityler de sinilir..
    // Fetch -> ilişkili verinin ne zaman yükleneceğini belirtir.
    //LAZY ->Veri başlangıçta değil ilk kulanıldığında yüklenir.
    //EAGER ->Veri başlangıçta(ana sorguda) yüklenir
    //
}
