package com.example.practice.dao.impl;

import com.example.practice.dao.BookDao;
import com.example.practice.model.Address;
import com.example.practice.model.Book;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.isNull;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    private static final String FIND_ALL_BOOKS = "SELECT * from Books";

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
    public List<Book> findAllBooks() {
        Query query = sessionFactory.getCurrentSession().createQuery(FIND_ALL_BOOKS);
        if (query.list().isEmpty()) {
            return null;
        }
        return (List<Book>) query.list();
    }
}
