package com.example.practice.dao.impl;

import com.example.practice.dao.CustomerDao;
import com.example.practice.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static java.util.Objects.isNull;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    private static final String FIND_ALL_CUSTOMERS = "SELECT * from Customers";
    private static final String FIND_CUSTOMER = "SELECT * from Customers where login=?";


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createCustomer(Customer customer) {
        if (isNull(customer)) {
            throw new IllegalArgumentException("customer is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .save(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        if (isNull(customer)) {
            throw new IllegalArgumentException("customer is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .update(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeCustomer(Customer customer) {
        if (isNull(customer)) {
            throw new IllegalArgumentException("customer is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .remove(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> findAllCustomers() {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_ALL_CUSTOMERS);
        List<Customer> customerList = (List<Customer>) query.addEntity(Customer.class).getResultList();
        if (customerList.isEmpty()) {
            return Collections.emptyList();
        }
        return customerList;
    }

    @Override
    public Customer finByLogin(String login) {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_CUSTOMER);
        query.setParameter(1, login);
        Customer customer = (Customer) query.addEntity(Customer.class).getSingleResult();
        if (isNull(customer)) {
            return null;
        }
        return customer;
    }
}
