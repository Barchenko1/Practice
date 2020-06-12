package com.example.practice.dao;

import com.example.practice.model.Book;

import java.util.List;

public interface BookDao {
    void createBook(Book book);

    void updateBook(Book book);

    void removeBook(Book book);

    List<Book> findAllBooks();
}
