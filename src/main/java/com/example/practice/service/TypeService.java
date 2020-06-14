package com.example.practice.service;

import com.example.practice.model.Type;

import java.util.List;

public interface TypeService {
    void createType(Type type);

    void updateType(Type type);

    void removeType(Type type);

    Type findById(int id);

    List<Type> findAllTypes();
}
