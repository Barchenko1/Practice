package com.example.practice.service;

import com.example.practice.model.Title;

import java.util.List;

public interface OrderService {
    void createTitle(Title title);

    void updateBook(Title title);

    void removeBook(Title title);

    List<Object> findAllTitles();
}
