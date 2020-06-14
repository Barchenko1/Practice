package com.example.practice.dao;

import com.example.practice.dto.TitleDto;

import java.util.List;

public interface TitleDao {
    List<TitleDto> findAuthorTitleBook();
}
