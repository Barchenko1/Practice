package com.example.practice.controller;

import com.example.practice.model.Customer;
import com.example.practice.model.TestDto;
import com.example.practice.model.Title;
import com.example.practice.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/title")
public class TitleController {
    @Autowired
    private TitleService titleService;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createCustomer(@RequestBody Title title) {
        titleService.createTitle(title);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Object> findAllTitles() {
        return titleService.findAllTitles();
    }
}
