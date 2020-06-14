package com.example.practice.service.impl;

import com.example.practice.dao.CustomerDao;
import com.example.practice.model.Customer;
import com.example.practice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void createCustomer(Customer customer) {
        customerDao.createCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    @Override
    public void removeCustomer(Customer customer) {
        customerDao.removeCustomer(customer);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerDao.findAllCustomers();
    }

    @Override
    public Customer findById(int id) {
        return customerDao.finById(id);
    }
}
