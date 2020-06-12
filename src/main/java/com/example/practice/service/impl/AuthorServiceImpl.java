package com.example.practice.service.impl;

import com.example.practice.dao.AuthorDao;
import com.example.practice.model.Author;
import com.example.practice.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public void createAuthor(Author author) {
        authorDao.createAuthor(author);
    }

    @Override
    public void updateAuthor(Author author) {
        authorDao.updateAuthor(author);
    }

    @Override
    public void removeAuthor(Author author) {
        authorDao.removeAuthor(author);
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorDao.findAllAuthors();
    }
}
