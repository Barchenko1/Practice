package com.example.practice.service;

import com.example.practice.dto.TitleBookIdDto;
import com.example.practice.dto.TitleDto;
import com.example.practice.model.Title;

import java.util.List;

public interface TitleService {

    void createTitle(TitleBookIdDto title);

    void updateTitle(int id, TitleBookIdDto title);

    void removeTitle(Title title);

    Title findTitleByBookAuthorId(int book_id, int author_id);

    List<TitleDto> findAllTitles();

    List<TitleDto> findSearchTitle(String searchString);

    List<TitleDto> findSortedTitle();
}
