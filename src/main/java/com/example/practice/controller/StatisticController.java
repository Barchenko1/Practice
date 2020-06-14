package com.example.practice.controller;

import com.example.practice.service.AuthorService;
import com.example.practice.service.BookService;
import com.example.practice.service.CustomerService;
import com.example.practice.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static com.example.practice.util.Constants.STATISTIC_PAGE;

@RestController
@RequestMapping("/statistic")
public class StatisticController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected ModelAndView getTypePage() {
        ModelAndView modelAndView = new ModelAndView();
        Number typeCount = typeService.findCount();
        Number bookCount = bookService.findCount();
        Number authorCount = authorService.findCount();
        Number customerCount = customerService.findCount();
        modelAndView.addObject("typeCount", typeCount);
        modelAndView.addObject("bookCount", bookCount);
        modelAndView.addObject("authorCount", authorCount);
        modelAndView.addObject("customerCount", customerCount);
        modelAndView.setViewName(STATISTIC_PAGE);
        return modelAndView;
    }
}
