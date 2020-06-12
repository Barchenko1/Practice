package com.example.practice.dao.impl;

import com.example.practice.dao.BookDao;
import com.example.practice.model.Address;
import com.example.practice.model.Book;
import com.example.practice.model.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
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
    private static final String FIND_BOOK = "SELECT * from Books where title = ?";


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
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_ALL_BOOKS);
        List<Book> bookList = (List<Book>) query.addEntity(Book.class).getResultList();
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
