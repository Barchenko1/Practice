package com.example.practice.service;

import com.example.practice.model.Book;

import java.util.List;

public interface BookService {
    void createBook(Book book);

    void updateBook(Book book);

    void removeBook(Book book);

    List<Book> findAllBooks();
}
