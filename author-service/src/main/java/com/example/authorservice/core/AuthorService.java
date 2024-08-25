package com.example.authorservice.core;

import com.example.authorservice.core.dao.Author;
import com.example.authorservice.core.dao.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public Author update(Integer authorId, Author author) {
        return authorRepository.updateById(authorId,
                author.getLastname(),
                author.getFirstname(),
                author.getMiddlename(),
                author.getNative());
    }

    public Optional<Author> findById(Integer authorId) {
        return authorRepository.findById(authorId);
    }

    public Author findAllBooksByAuthorId(Integer id) {
        return authorRepository.findAllBooksByAuthorId(id);
    }

    public Author findAllBooksByAuthorFio(Author author) {
        String lastname = (author.getLastname() != null ) ? author.getLastname().toLowerCase() : null;
        String firstname = (author.getFirstname() != null ) ? author.getFirstname().toLowerCase() : null;
        String middlename = (author.getMiddlename() != null ? author.getMiddlename().toLowerCase() : null);
        return authorRepository.findAllBooksByAuthorFio(
                lastname,
                firstname,
                middlename,
                author.getNative());
    }

    public void delete(Integer authorId) { authorRepository.deleteById(authorId); }
}
