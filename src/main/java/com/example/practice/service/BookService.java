package com.example.practice.service;

import com.example.practice.dto.BookTypeDto;
import com.example.practice.model.Book;

import java.util.List;

public interface BookService {
    void createBook(Book book);

    void updateBook(Book book);

    void removeBook(Book book);

    List<BookTypeDto> findAllBooksTypes();

    Book findBookByTitle(String title);
}
