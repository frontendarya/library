package com.example.categoryservice.core.dao;

import com.example.bookservice.core.dao.Book;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @SequenceGenerator(name = "id", sequenceName = "id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "id_seq")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="category", cascade = { CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.REFRESH })
    private Set<Book> books;

    public Category() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
