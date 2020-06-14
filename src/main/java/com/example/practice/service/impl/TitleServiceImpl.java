package com.example.practice.service.impl;

import com.example.practice.dao.TitleDao;
import com.example.practice.dto.TitleDto;
import com.example.practice.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleServiceImpl implements TitleService {

    @Autowired
    private TitleDao titleDao;

    @Override
    public List<TitleDto> findAllTitles() {
        return titleDao.findAuthorTitleBook();
    }
}
