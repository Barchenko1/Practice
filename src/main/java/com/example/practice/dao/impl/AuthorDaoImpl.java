package com.example.practice.dao.impl;

import com.example.practice.dao.AuthorDao;
import com.example.practice.model.Author;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.isNull;

@Repository
@Transactional
public class AuthorDaoImpl implements AuthorDao {

    private static final String FIND_ALL_CUSTOMERS = "SELECT * from Authors";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createAuthor(Author author) {
        if (isNull(author)) {
            throw new IllegalArgumentException("author is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .save(author);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAuthor(Author author) {
        if (isNull(author)) {
            throw new IllegalArgumentException("author is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .update(author);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeAuthor(Author author) {
        if (isNull(author)) {
            throw new IllegalArgumentException("author is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .remove(author);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Author> findAllAuthors() {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_ALL_CUSTOMERS);
        List<Author> authorList = (List<Author>) query.addEntity(Author.class).getResultList();
        if (authorList.isEmpty()) {
            return null;
        }
        return authorList;
    }
}
