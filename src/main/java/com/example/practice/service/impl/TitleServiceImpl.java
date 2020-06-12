package com.example.practice.service.impl;

import com.example.practice.dao.TitleDao;
import com.example.practice.model.TestDto;
import com.example.practice.model.Title;
import com.example.practice.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleServiceImpl implements TitleService {

    @Autowired
    private TitleDao titleDao;

    @Override
    public void createTitle(Title title) {
        titleDao.createTitle(title);
    }

    @Override
    public void updateBook(Title title) {

    }

    @Override
    public void removeBook(Title title) {

    }

    @Override
    public List<Object> findAllTitles() {
        return titleDao.findAllTitles();
    }
}
