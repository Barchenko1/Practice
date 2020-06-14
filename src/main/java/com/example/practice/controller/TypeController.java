package com.example.practice.controller;

import com.example.practice.model.Customer;
import com.example.practice.model.Type;
import com.example.practice.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.example.practice.util.Constants.*;

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
    public ModelAndView createBook(@ModelAttribute("type") Type type) {
        typeService.createType(type);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/type/");
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView updateAuthorGet(@PathVariable("id") int id) {
        Type type = typeService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(UPDATE_TYPE_PAGE);
        modelAndView.addObject("type", type);
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ModelAndView updateAuthorPost(@PathVariable("id") int id,
                                         @ModelAttribute("type") Type type) {
        type.setType_id((long) id);
        typeService.updateType(type);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/type/");
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAuthor(@PathVariable("id") int id) {
        Type type = typeService.findById(id);
        typeService.removeType(type);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/type/");
        return modelAndView;
    }
}
