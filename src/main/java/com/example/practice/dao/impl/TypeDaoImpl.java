package com.example.practice.dao.impl;

import com.example.practice.dao.TypeDao;
import com.example.practice.model.Type;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static java.util.Objects.isNull;

@Repository
@Transactional
public class TypeDaoImpl implements TypeDao {

    private static final String FIND_ALL_TYPES = "SELECT * from Types";
    private static final String FIND_TYPE_BY_ID = "SELECT * from Types where type_id=?";
    private static final String FIND_TYPE_BY_NAME = "SELECT * from Types where type_name=?";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createType(Type type) {
        if (isNull(type)) {
            throw new IllegalArgumentException("type is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .save(type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateType(Type type) {
        if (isNull(type)) {
            throw new IllegalArgumentException("type is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .update(type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeType(Type type) {
        if (isNull(type)) {
            throw new IllegalArgumentException("type is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .remove(type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Type> findAllTypes() {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_ALL_TYPES);
        List<Type> typeList = (List<Type>) query.addEntity(Type.class).getResultList();
        if (typeList.isEmpty()) {
            return Collections.emptyList();
        }
        return typeList;
    }

    @Override
    public Type findTypeById(int id) {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_TYPE_BY_ID);
        query.setParameter(1, id);
        Type type = (Type) query.addEntity(Type.class).getSingleResult();
        if (isNull(type)) {
            return null;
        }
        return type;
    }

    @Override
    public Type findTypeByName(String type_name) {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_TYPE_BY_NAME);
        query.setParameter(1, type_name);
        Type type = (Type) query.addEntity(Type.class).getSingleResult();
        if (isNull(type)) {
            return null;
        }
        return type;
    }

}
