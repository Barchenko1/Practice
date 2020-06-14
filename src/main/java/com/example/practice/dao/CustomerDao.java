package com.example.practice.dao;

import com.example.practice.model.Customer;

import java.util.List;

public interface CustomerDao {
    void createCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void removeCustomer(Customer customer);

    List<Customer> findAllCustomers();

    Customer finById(int id);

    Number findCount();
}
