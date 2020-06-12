package com.example.practice.controller;

import com.example.practice.model.Author;
import com.example.practice.model.Customer;
import com.example.practice.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping(value = "/create")
    public void createAuthor(@RequestBody Author author) {
        authorService.createAuthor(author);
    }

    @PutMapping(value = "/update")
    public void updateAuthor(@RequestBody Author author) {
        authorService.updateAuthor(author);
    }

    @DeleteMapping(value = "/delete")
    public void deleteAuthor(@RequestBody Author author) {
        authorService.removeAuthor(author);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Author> findAllAuthors() {
        return authorService.findAllAuthors();
    }

//    @RequestMapping(value = "/find/{login}", method = RequestMethod.GET)
//    public Customer findAuthor(@PathVariable("login") String login) {
//        return authorService.finByLogin(login);
//    }
}
