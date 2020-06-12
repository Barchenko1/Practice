package com.example.practice.service;

import com.example.practice.model.TestDto;
import com.example.practice.model.Title;

import java.util.List;

public interface TitleService {
    void createTitle(Title title);

    void updateBook(Title title);

    void removeBook(Title title);

    List<Object> findAllTitles();

}
