package com.example.practice.dao;

import com.example.practice.model.Type;

import java.util.List;

public interface TypeDao {
    void createType(Type type);

    void updateType(Type type);

    void removeType(Type type);

    List<Type> findAllTypes();

    Type findTypeById(int id);

    Type findTypeByName(String type_name);
}
