package com.example.practice.dao.impl;

import com.example.practice.dao.OrderDao;
import com.example.practice.dto.OrderDto;
import com.example.practice.model.Order;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

import static java.util.Objects.isNull;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

    private static final String FIND_ALL_ORDERS = "SELECT * from Orders";
    private static final String FIND_JOINER_ORDERS_CUSTOMERS_BOOKS = "SELECT b.book_id, c.customer_id, b.title, b.price, b.circulation, b.advance, b.public_date, c.f_name, c.l_name, c.email\n" +
            "FROM Orders o\n" +
            "  JOIN Books b ON b.book_id=o.book_id\n" +
            "  JOIN Customers c ON c.customer_id=o.customer_id";
    private static final String FIND_ALL_TITLES_BOOK_CUSTOMER_ID = "SELECT * from Orders where book_id=? and customer_id=?";


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
    public List<OrderDto> findAllOrders() {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_JOINER_ORDERS_CUSTOMERS_BOOKS);
        query.setResultTransformer(Transformers.aliasToBean(OrderDto.class));
        List<OrderDto> orderDaoList = query.getResultList();
        if (orderDaoList.isEmpty()) {
            return null;
        }
        return orderDaoList;
    }

    @Override
    public Order findTitleByBookCustomerId(int book_id, int customer_id) {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_ALL_TITLES_BOOK_CUSTOMER_ID);
        query.setParameter(1, book_id);
        query.setParameter(2, customer_id);
        Order order = null;
        try {
            order = (Order) query.addEntity(Order.class).getSingleResult();
        } catch (NoResultException ex) {

        }
        return order;    }
}
