package com.example.practice.dao;


import com.example.practice.model.Author;

import java.util.List;

public interface AuthorDao {
    void createAuthor(Author author);

    void updateAuthor(Author author);

    void removeAuthor(Author author);

    List<Author> findAllAuthors();

    Author findById(int id);

    Number findCount();
}
