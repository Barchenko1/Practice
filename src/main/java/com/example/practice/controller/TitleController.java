package com.example.practice.controller;

import com.example.practice.dto.TitleDto;
import com.example.practice.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/title")
public class TitleController {
    @Autowired
    private TitleService titleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected ModelAndView pageGet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("titlePage");
        return modelAndView;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<TitleDto> findAllTitles() {
        return titleService.findAllTitles();
    }
}
