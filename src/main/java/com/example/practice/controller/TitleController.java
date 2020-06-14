package com.example.practice.controller;

import com.example.practice.dto.BookTypeDto;
import com.example.practice.dto.TitleDto;
import com.example.practice.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.example.practice.util.Constants.TITLE_PAGE;

@RestController
@RequestMapping("/title")
public class TitleController {
    @Autowired
    private TitleService titleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected ModelAndView getTypePage() {
        ModelAndView modelAndView = new ModelAndView();
        List<TitleDto> titleDtoList = titleService.findAllTitles();
        modelAndView.addObject("titleDtoList", titleDtoList);
        modelAndView.setViewName(TITLE_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<TitleDto> findAllTitles() {
        return titleService.findAllTitles();
    }
}
