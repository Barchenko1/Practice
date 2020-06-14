package com.example.practice.service;

import com.example.practice.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthorService {
    void createAuthor(Author author);

    void updateAuthor(Author author);

    void removeAuthor(Author author);

    List<Author> findAllAuthors();

    Author findById(int id);

    Number findCount();
}
