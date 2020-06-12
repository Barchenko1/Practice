package com.example.practice.controller;

import com.example.practice.model.Book;
import com.example.practice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createBook(@RequestBody Book book) {
        bookService.createBook(book);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteBook(@RequestBody Book book) {
        bookService.removeBook(book);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Book> findBooks() {
        return bookService.findAllBooks();
    }

    @RequestMapping(value = "/find/{title}", method = RequestMethod.GET)
    public Book findBookByTitle(@PathVariable("title") String title) {
        return bookService.findBookByTitle(title);
    }
}
