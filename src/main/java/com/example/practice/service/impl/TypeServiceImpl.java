package com.example.practice.service.impl;

import com.example.practice.dao.TypeDao;
import com.example.practice.model.Type;
import com.example.practice.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public void createType(Type type) {
        typeDao.createType(type);
    }

    @Override
    public void updateType(Type type) {
        typeDao.updateType(type);
    }

    @Override
    public void removeType(Type type) {
        typeDao.removeType(type);
    }

    @Override
    public Type findById(int id) {
        return typeDao.findTypeById(id);
    }

    @Override
    public List<Type> findAllTypes() {
        return typeDao.findAllTypes();
    }

    @Override
    public Number findCount() {
        return typeDao.findCount();
    }

}
