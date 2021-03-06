package com.example.practice.dao;

import com.example.practice.dto.BookTypeDto;
import com.example.practice.model.Book;

import java.util.List;

public interface BookDao {
    void createBook(Book book);

    void updateBook(Book book);

    void removeBook(Book book);

    List<BookTypeDto> findAllBooksTypes();

    Book findById(int id);

    Book findBookByTitle(String title);

    Number findCount();

    List<BookTypeDto> findAllBooksByType(int id);
}
