package com.example.practice.controller;

import com.example.practice.dto.BookTypeDto;
import com.example.practice.model.Book;
import com.example.practice.model.Type;
import com.example.practice.service.BookService;
import com.example.practice.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.example.practice.util.Constants.*;


@PropertySource(value = "classpath:pages.properties")
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected ModelAndView getBookPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<BookTypeDto> bookList = bookService.findAllBooksTypes();
        List<Type> typeList = typeService.findAllTypes();
        modelAndView.addObject("bookList", bookList);
        modelAndView.addObject("typeList", typeList);
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
    public ModelAndView createBook(@ModelAttribute("bookTypeDto") BookTypeDto bookTypeDto) {
        bookService.createBook(bookTypeDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/book/");
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView updateAuthorGet(@PathVariable("id") int id) {
        Book book = bookService.findById(id);
        int type_id = Math.toIntExact(book.getType().getType_id());
        Type type = typeService.findById(type_id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(UPDATE_BOOK_PAGE);
        modelAndView.addObject("book", book);
        modelAndView.addObject("type", type);
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ModelAndView updateAuthorPost(@PathVariable("id") int id,
                                         @ModelAttribute("bookTypeDto") BookTypeDto bookTypeDto) {
        bookTypeDto.setBook_id(id);
        bookService.updateBook(bookTypeDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/book/");
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAuthor(@PathVariable("id") int id) {
        Book book = bookService.findById(id);
        bookService.removeBook(book);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/book/");
        return modelAndView;
    }

    @RequestMapping(value = "/filter/{type_id}", method = RequestMethod.GET)
    protected ModelAndView getFilterPage(@PathVariable("type_id") int type_id) {
        ModelAndView modelAndView = new ModelAndView();
        List<BookTypeDto> bookList = bookService.findAllBooksByType(type_id);
        List<Type> typeList = typeService.findAllTypes();
        modelAndView.addObject("bookList", bookList);
        modelAndView.addObject("typeList", typeList);
        modelAndView.setViewName(BOOK_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/find/{title}", method = RequestMethod.GET)
    public Book findBookByTitle(@PathVariable("title") String title) {
        return bookService.findBookByTitle(title);
    }
}
