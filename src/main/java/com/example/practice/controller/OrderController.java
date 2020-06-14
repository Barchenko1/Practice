package com.example.practice.controller;

import com.example.practice.model.Title;
import com.example.practice.service.OrderService;
import com.example.practice.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.example.practice.util.Constants.ORDER_PAGE;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected ModelAndView pageGet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(ORDER_PAGE);
        return modelAndView;
    }

}
