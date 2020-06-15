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
    public void createBook(BookTypeDto bookTypeDto) {
        Type type = typeDao.findTypeByName(bookTypeDto.getType_name());
        if (isNull(type)){
            typeDao.createType(createTypeObject(bookTypeDto.getType_name()));
            type = typeDao.findTypeByName(bookTypeDto.getType_name());
        }
        bookDao.createBook(createBookObject(bookTypeDto, type));
    }


    @Override
    public void updateBook(BookTypeDto bookTypeDto) {
        Type type = typeDao.findTypeByName(bookTypeDto.getType_name());
        if (isNull(type)){
            typeDao.createType(createTypeObject(bookTypeDto.getType_name()));
            type = typeDao.findTypeByName(bookTypeDto.getType_name());
        }
        Book newBook = createBookObject(bookTypeDto, type);
        newBook.setBook_id((long) bookTypeDto.getBook_id());
        bookDao.updateBook(newBook);
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
    public Book findById(int id) {
        return bookDao.findById(id);
    }

    @Override
    public Book findBookByTitle(String title) {
        return bookDao.findBookByTitle(title);
    }

    @Override
    public Number findCount() {
        return bookDao.findCount();
    }

    private boolean hasType(String type_name) {
        Type type = typeDao.findTypeByName(type_name);
        return nonNull(type);
    }

    private Book createBookObject(BookTypeDto bookTypeDto, Type type) {
        Book book = new Book();
        book.setTitle(bookTypeDto.getTitle());
        book.setPrice(bookTypeDto.getPrice());
        book.setCirculation(bookTypeDto.getCirculation());
        book.setAdvance(bookTypeDto.getAdvance());
        book.setPublic_date(bookTypeDto.getPublic_date());
        book.setType(type);
        return book;

    }

    private Type createTypeObject(String type_name) {
        Type type = new Type();
        type.setType_name(type_name);
        return type;
    }
}
