package com.example.practice.dao.impl;

import com.example.practice.dao.TitleDao;
import com.example.practice.model.Title;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.isNull;

@Repository
@Transactional
public class TitleDaoImpl implements TitleDao {

    private static final String FIND_ALL_TITLES = "SELECT * from Titles";
    private static final String FIND_JOINER = "SELECT t.author_pay, b.title, a.f_name\n" +
            "FROM Titles t\n" +
            "  JOIN Books b ON t.book_id=b.book_id\n" +
            "  JOIN Authors a ON t.author_id=a.author_id";


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createTitle(Title title) {
        if (isNull(title)) {
            throw new IllegalArgumentException("title is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .save(title);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateTitle(Title title) {

    }

    @Override
    public void removeTitle(Title title) {

    }

    @Override
    public List<Object> findAllTitles() {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_JOINER);
        List<Object> objectList = query.getResultList();
        if (isNull(objectList)) {
            return null;
        }
        return objectList;
    }
}
