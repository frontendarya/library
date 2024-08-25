package com.example.bookservice.core;

import com.example.bookservice.core.dao.Book;
import com.example.bookservice.core.dao.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> findById(Integer bookId) {
        return bookRepository.findById(bookId);
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findByTittle(title.toLowerCase());
    }

    public Book getDetailsById(Integer id) {
        return bookRepository.getDetailsById(id);
    }

    public void delete(Integer bookId) { bookRepository.deleteById(bookId); }
}
