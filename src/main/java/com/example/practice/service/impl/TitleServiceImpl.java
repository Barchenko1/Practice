package com.example.practice.service.impl;

import com.example.practice.dao.TitleDao;
import com.example.practice.dto.TitleBookIdDto;
import com.example.practice.dto.TitleDto;
import com.example.practice.model.*;
import com.example.practice.service.AuthorService;
import com.example.practice.service.BookService;
import com.example.practice.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class TitleServiceImpl implements TitleService {

    @Autowired
    private TitleDao titleDao;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Override
    public void createTitle(TitleBookIdDto titleBookIdDto) {
        Book book = bookService.findById(titleBookIdDto.getBook_id());
        Author author = authorService.findById(titleBookIdDto.getAuthor_id());
        Title title = new Title();
        title.setBook(book);
        title.setAuthor(author);
        titleDao.createTitle(title);
    }

    @Override
    public void updateTitle(int id, TitleBookIdDto titleBookIdDto) {
        Book book = bookService.findById(titleBookIdDto.getBook_id());
        Author author = authorService.findById(titleBookIdDto.getAuthor_id());
        Title title = new Title();
        title.setTitle_id((long) id);
        title.setBook(book);
        title.setAuthor(author);
        titleDao.updateTitle(title);
    }

    @Override
    public void removeTitle(Title title) {
        titleDao.removeTitle(title);
    }

    @Override
    public Title findTitleByBookAuthorId(int book_id, int author_id) {
        return titleDao.findTitleByBookAuthorId(book_id, author_id);
    }

    @Override
    public List<TitleDto> findAllTitles() {
        return titleDao.findAuthorTitleBook();
    }

    @Override
    public List<TitleDto> findSearchTitle(String searchString) {
        List<TitleDto> titleDtoList = titleDao.findSearchTitle(searchString);
        if (isNull(titleDtoList)) {
            return Collections.emptyList();
        }
        return titleDtoList;
    }

    @Override
    public List<TitleDto> findSortedTitleAuthor() {
        return titleDao.findSortedTitleAuthor();
    }

    @Override
    public List<TitleDto> findSortedTitlePrice() {
        return titleDao.findSortedTitlePrice();
    }
}
