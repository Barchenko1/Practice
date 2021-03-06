package com.example.practice.dao.impl;

import com.example.practice.dao.BookDao;
import com.example.practice.dto.BookTypeDto;
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
    private static final String FIND_BOOK_BY_TITLE = "SELECT * from Books where title = ?";
    private static final String FIND_ALL_BOOKS_TYPES = "SELECT b.book_id, b.title, b.price, b.circulation, b.advance, b.public_date, t.type_name FROM Books b JOIN Types t ON b.type_id=t.type_id";
    private static final String COUNT_OF_BOOKS = "SELECT COUNT(*) from Books";
    private static final String FIND_BOOK_BY_ID = "SELECT * from Books where book_id = ?";
    private static final String FIND_ALL_BOOKS_BY_TYPE = "SELECT b.book_id, b.title, b.price, b.circulation, b.advance, b.public_date, t.type_name FROM Books b JOIN Types t ON b.type_id=t.type_id where t.type_id=?";


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
                    .update(book);
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
    public Book findById(int id) {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_BOOK_BY_ID);
        query.setParameter(1, id);
        Book book = (Book) query.addEntity(Book.class).getSingleResult();
        if (isNull(book)) {
            return null;
        }
        return book;
    }

    @Override
    public Book findBookByTitle(String title) {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_BOOK_BY_TITLE);
        query.setParameter(1, title);
        Book book = (Book) query.addEntity(Book.class).getSingleResult();
        if (isNull(book)) {
            return null;
        }
        return book;
    }

    @Override
    public Number findCount() {
        return  ((Number) sessionFactory.getCurrentSession()
                .createSQLQuery(COUNT_OF_BOOKS)
                .uniqueResult()).longValue();
    }

    @Override
    public List<BookTypeDto> findAllBooksByType(int id) {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_ALL_BOOKS_BY_TYPE);
        query.setParameter(1, id);
        query.setResultTransformer(Transformers.aliasToBean(BookTypeDto.class));
        List<BookTypeDto> bookList = (List<BookTypeDto>) query.getResultList();
        if (bookList.isEmpty()) {
            return null;
        }
        return bookList;
    }


}
