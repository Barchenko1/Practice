package com.example.practice.dao.impl;

import com.example.practice.dao.OrderDao;
import com.example.practice.model.Order;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Objects.isNull;

@Repository
public class OrderDaoImpl implements OrderDao {

    private static final String FIND_ALL_ORDERS = "SELECT * from Orders";
    private static final String FIND_JOINER = "SELECT t.author_pay, b.title, a.f_name\n" +
            "FROM Titles t\n" +
            "  JOIN Books b ON t.book_id=b.book_id\n" +
            "  JOIN Authors a ON t.author_id=a.author_id";


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createOrder(Order order) {
        if (isNull(order)) {
            throw new IllegalArgumentException("order is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .save(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateOrder(Order order) {
        if (isNull(order)) {
            throw new IllegalArgumentException("order is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .update(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeOrder(Order order) {
        if (isNull(order)) {
            throw new IllegalArgumentException("order is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .remove(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> findAllOrders() {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_JOINER);
        List<Order> objectList = query.getResultList();
        if (isNull(objectList)) {
            return null;
        }
        return objectList;
    }
}
