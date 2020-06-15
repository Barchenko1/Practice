package com.example.practice.dao.impl;

import com.example.practice.dao.TitleDao;
import com.example.practice.dto.TitleDto;
import com.example.practice.model.Title;
import com.example.practice.model.Type;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

import static java.util.Objects.isNull;

@Repository
@Transactional
public class TitleDaoImpl implements TitleDao {

    private static final String FIND_ALL_TITLES = "SELECT * from Titles";
    private static final String FIND_JOINER_BOOKS_AUTHORS_TITLES = "SELECT b.book_id, a.author_id, b.title, b.price, b.circulation, a.f_name, a.l_name, a.author_pay\n" +
            "FROM Titles t\n" +
            "  JOIN Books b ON t.book_id=b.book_id\n" +
            "  JOIN Authors a ON t.author_id=a.author_id";
    private static final String FIND_ALL_TITLES_BOOK_AUTHOR_ID = "SELECT * from Titles where book_id=? and author_id=?";


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
        if (isNull(title)) {
            throw new IllegalArgumentException("title is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .update(title);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }    }

    @Override
    public void removeTitle(Title title) {
        if (isNull(title)) {
            throw new IllegalArgumentException("title is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .remove(title);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Title findTitleByBookAuthorId(int book_id, int author_id) {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_ALL_TITLES_BOOK_AUTHOR_ID);
        query.setParameter(1, book_id);
        query.setParameter(2, author_id);
        Title title = null;
        try {
            title = (Title) query.addEntity(Title.class).getSingleResult();
        } catch (NoResultException ex) {

        }
        return title;
    }

    @Override
    public List<TitleDto> findAuthorTitleBook() {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_JOINER_BOOKS_AUTHORS_TITLES);
        query.setResultTransformer(Transformers.aliasToBean(TitleDto.class));
        List<TitleDto> authorTitleBookList = query.getResultList();
        if (authorTitleBookList.isEmpty()) {
            return null;
        }
        return authorTitleBookList;
    }
}
