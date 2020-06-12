package com.example.practice.controller;

import com.example.practice.model.Customer;
import com.example.practice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

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
