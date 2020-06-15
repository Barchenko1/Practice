package com.example.practice.dao.impl;

import com.example.practice.dao.RandomRequestDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Repository
@Transactional
public class RandomRequestDaoImpl implements RandomRequestDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Object findObject(String querySQL) {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(querySQL);
        List<Object> objectList = query.getResultList();
        Iterator it = objectList.iterator();
        Object[] row = null;
        List<Object[]> objects = new ArrayList<>();
//        while (it.hasNext())
//        {
//            row = (Object[]) it.next();
//            for (Object o : row) {
//                stringList.add(o.toString());
//            }
//        }
        while (it.hasNext()){
            row = (Object[]) it.next();
            objects.add(row);
        }
        return objects;
    }
}
