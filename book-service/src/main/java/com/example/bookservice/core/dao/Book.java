package com.example.bookservice.core.dao;


import com.example.authorservice.core.dao.Author;
import com.example.categoryservice.core.dao.Category;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @SequenceGenerator(name = "id", sequenceName = "id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "id_seq")
    @Column(name = "id")
    private Integer id;

    @ManyToMany(mappedBy = "books")
    Set<Author> authors;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public Book() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
