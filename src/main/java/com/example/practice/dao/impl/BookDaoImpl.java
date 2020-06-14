package com.example.practice.dao.impl;

import com.example.practice.dao.BookDao;
import com.example.practice.dto.BookTypeDto;
import com.example.practice.dto.TitleDto;
import com.example.practice.model.Book;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.isNull;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    private static final String FIND_ALL_BOOKS = "SELECT * from Books";
    private static final String FIND_BOOK = "SELECT * from Books where title = ?";
    private static final String FIND_ALL_BOOKS_TYPES = "SELECT b.title, b.price, b.circulation, b.advance, b.public_date, t.type_name FROM Books b JOIN Types t ON b.type_id=t.type_id";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createBook(Book book) {
        if (isNull(book)) {
            throw new IllegalArgumentException("book is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .save(book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateBook(Book book) {
        if (isNull(book)) {
            throw new IllegalArgumentException("book is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .delete(book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeBook(Book book) {
        if (isNull(book)) {
            throw new IllegalArgumentException("book is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .remove(book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BookTypeDto> findAllBooksTypes() {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_ALL_BOOKS_TYPES);
        query.setResultTransformer(Transformers.aliasToBean(BookTypeDto.class));
        List<BookTypeDto> bookList = (List<BookTypeDto>) query.getResultList();
        if (bookList.isEmpty()) {
            return null;
        }
        return bookList;
    }

    @Override
    public Book findBookByTitle(String title) {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_BOOK);
        query.setParameter(1, title);
        if (isNull(query.getSingleResult())) {
            return null;
        }
        return (Book) query.addEntity(Book.class).getSingleResult();
    }


}
