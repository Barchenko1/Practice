package com.example.practice.controller;

import com.example.practice.dao.RandomRequestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.example.practice.util.Constants.RANDOM_REQUEST_PAGE;

@RestController
@RequestMapping("/randomRequest")
public class RandomRequestController {
    @Autowired
    private RandomRequestDao randomRequestDao;

    private List<Object[]> objectList;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected ModelAndView pageGet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("objectList", objectList);
        modelAndView.setViewName(RANDOM_REQUEST_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/execute", method = RequestMethod.POST)
    public ModelAndView createAuthor(@ModelAttribute("query") String query) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/randomRequest/");
        if (query.isEmpty()){
            return modelAndView;
        }
        objectList = (List<Object[]>) randomRequestDao.findObject(query);
        return modelAndView;
    }
}
