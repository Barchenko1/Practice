package com.example.practice.dao.impl;

import com.example.practice.dao.TitleDao;
import com.example.practice.dto.TitleDto;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TitleDaoImpl implements TitleDao {

    private static final String FIND_ALL_TITLES = "SELECT * from Titles";
    private static final String FIND_JOINER_BOOKS_AUTHORS_TITLES = "SELECT b.title, b.price, b.circulation, a.f_name, a.l_name, a.author_pay\n" +
            "FROM Titles t\n" +
            "  JOIN Books b ON t.book_id=b.book_id\n" +
            "  JOIN Authors a ON t.author_id=a.author_id";


    @Autowired
    private SessionFactory sessionFactory;

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
