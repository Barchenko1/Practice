package com.example.practice.service;

import com.example.practice.model.Customer;

import java.util.List;

public interface CustomerService {
    void createCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void removeCustomer(Customer customer);

    List<Customer> findAllCustomers();

    Customer finByLogin(String login);
}
