package com.example.practice.service.impl;

import com.example.practice.dao.BookDao;
import com.example.practice.dao.TypeDao;
import com.example.practice.dto.BookTypeDto;
import com.example.practice.model.Book;
import com.example.practice.model.Type;
import com.example.practice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private TypeDao typeDao;

    @Override
    public void createBook(Book book) {
        Type type = typeDao.findTypeByName(book.getType().getType_name());
        if (isNull(type)){
            typeDao.createType(book.getType());
            type = typeDao.findTypeByName(book.getType().getType_name());
        }
        book.setType(type);
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

    private boolean hasType(String type_name) {
        Type type = typeDao.findTypeByName(type_name);
        return nonNull(type);
    }
}
