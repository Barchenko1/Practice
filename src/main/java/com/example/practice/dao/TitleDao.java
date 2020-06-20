package com.example.practice.dao;

import com.example.practice.dto.TitleDto;
import com.example.practice.model.Title;

import java.util.List;

public interface TitleDao {
    void createTitle(Title title);

    void updateTitle(Title title);

    void removeTitle(Title title);

    Title findTitleByBookAuthorId(int book_id, int author_id);

    List<TitleDto> findAuthorTitleBook();

    List<TitleDto> findSearchTitle(String searchString);

    List<TitleDto> findSortedTitleAuthor();

    List<TitleDto> findSortedTitlePrice();
}
