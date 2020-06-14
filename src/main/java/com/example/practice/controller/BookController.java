package com.example.practice.controller;

import com.example.practice.dto.BookTypeDto;
import com.example.practice.model.Book;
import com.example.practice.model.Type;
import com.example.practice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.example.practice.util.Constants.BOOK_PAGE;
import static com.example.practice.util.Constants.CREATE_BOOK_PAGE;


@PropertySource(value = "classpath:pages.properties")
//@Controller
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected ModelAndView getBookPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<BookTypeDto> bookList = bookService.findAllBooksTypes();
        modelAndView.addObject("bookList", bookList);
        modelAndView.setViewName(BOOK_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createBookPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(CREATE_BOOK_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createBook(@ModelAttribute("book") Book book) {
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

//    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
//    public List<Book> findBooks() {
//        return bookService.findAllBooks();
//    }

    @RequestMapping(value = "/find/{title}", method = RequestMethod.GET)
    public Book findBookByTitle(@PathVariable("title") String title) {
        return bookService.findBookByTitle(title);
    }
}
