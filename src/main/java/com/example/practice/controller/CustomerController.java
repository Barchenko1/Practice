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
    public void createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteCustomer(@RequestBody Customer customer) {
        customerService.removeCustomer(customer);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Customer> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @RequestMapping(value = "/find/{login}", method = RequestMethod.GET)
    public Customer findCustomer(@PathVariable("login") String login) {
        return customerService.finByLogin(login);
    }

}
