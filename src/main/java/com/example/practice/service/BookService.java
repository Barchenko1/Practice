package com.example.practice.service;

import com.example.practice.dto.BookTypeDto;
import com.example.practice.model.Book;

import java.util.List;

public interface BookService {
    void createBook(BookTypeDto book);

    void updateBook(BookTypeDto book);

    void removeBook(Book book);

    List<BookTypeDto> findAllBooksTypes();

    Book findById(int id);

    Book findBookByTitle(String title);

    Number findCount();
}
