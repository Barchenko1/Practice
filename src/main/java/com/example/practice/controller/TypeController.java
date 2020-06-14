package com.example.practice.controller;

import com.example.practice.model.Type;
import com.example.practice.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.example.practice.util.Constants.CREATE_TYPE_PAGE;
import static com.example.practice.util.Constants.TYPE_PAGE;

@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected ModelAndView getTypePage() {
        ModelAndView modelAndView = new ModelAndView();
        List<Type> typeList = typeService.findAllTypes();
        modelAndView.addObject("typeList", typeList);
        modelAndView.setViewName(TYPE_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    protected ModelAndView createTypePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(CREATE_TYPE_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createBook(@ModelAttribute("type") Type type) {
        typeService.createType(type);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateBook(@RequestBody Type type) {
        typeService.updateType(type);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteBook(@RequestBody Type type) {
        typeService.removeType(type);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Type> findAllTypes() {
        return typeService.findAllTypes();
    }
}
