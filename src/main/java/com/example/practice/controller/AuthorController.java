package com.example.practice.controller;

import com.example.practice.model.Author;
import com.example.practice.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.example.practice.util.Constants.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected ModelAndView pageGet() {
        ModelAndView modelAndView = new ModelAndView();
        List<Author> authorList = authorService.findAllAuthors();
        modelAndView.addObject("authorList", authorList);
        modelAndView.setViewName(AUTHOR_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createBookPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(CREATE_AUTHOR_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createAuthor(@ModelAttribute("author") Author author) {
        authorService.createAuthor(author);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/author/");
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView updateAuthorGet(@PathVariable("id") int id) {
        Author author = authorService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(UPDATE_AUTHOR_PAGE);
        modelAndView.addObject("author", author);
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ModelAndView updateAuthorPost(@PathVariable("id") int id) {
        Author author = authorService.findById(id);
        authorService.updateAuthor(author);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/author/");
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAuthor(@PathVariable("id") int id) {
        Author author = authorService.findById(id);
        authorService.removeAuthor(author);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/author/");
        return modelAndView;
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
