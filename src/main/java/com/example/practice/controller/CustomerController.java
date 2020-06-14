package com.example.practice.controller;

import com.example.practice.model.Author;
import com.example.practice.model.Customer;
import com.example.practice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.example.practice.util.Constants.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected ModelAndView pageGet() {
        ModelAndView modelAndView = new ModelAndView();
        List<Customer> customerList = customerService.findAllCustomers();
        modelAndView.addObject("customerList", customerList);
        modelAndView.setViewName(CUSTOMER_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createBookPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(CREATE_CUSTOMER_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.createCustomer(customer);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/customer/");
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView updateAuthorGet(@PathVariable("id") int id) {
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(UPDATE_CUSTOMER_PAGE);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ModelAndView updateAuthorPost(@PathVariable("id") int id,
                                         @ModelAttribute("author") Customer customer) {
        customer.setCustomer_id((long) id);
        customerService.updateCustomer(customer);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/customer/");
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAuthor(@PathVariable("id") int id) {
        Customer customer = customerService.findById(id);
        customerService.removeCustomer(customer);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/customer/");
        return modelAndView;
    }

}
