package com.example.practice.service.impl;

import com.example.practice.dao.BookDao;
import com.example.practice.dto.BookTypeDto;
import com.example.practice.model.Book;
import com.example.practice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void createBook(Book book) {
        bookDao.createBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public void removeBook(Book book) {
        bookDao.removeBook(book);
    }

    @Override
    public List<BookTypeDto> findAllBooksTypes() {
        return bookDao.findAllBooksTypes();
    }

    @Override
    public Book findBookByTitle(String title) {
        return bookDao.findBookByTitle(title);
    }
}
