package com.example.practice.controller;

import com.example.practice.model.Author;
import com.example.practice.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected ModelAndView pageGet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("authorPage");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createAuthor(@RequestBody Author author) {
        authorService.createAuthor(author);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateAuthor(@RequestBody Author author) {
        authorService.updateAuthor(author);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
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
