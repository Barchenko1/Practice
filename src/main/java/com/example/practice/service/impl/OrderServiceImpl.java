package com.example.practice.service.impl;

import com.example.practice.dao.OrderDao;
import com.example.practice.dto.OrderDto;
import com.example.practice.model.Order;
import com.example.practice.model.Title;
import com.example.practice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void createOrder(Order order) {
        orderDao.createOrder(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderDao.updateOrder(order);
    }

    @Override
    public void removeOrder(Order order) {
        orderDao.removeOrder(order);
    }

    @Override
    public List<OrderDto> findAllOrder() {
        return orderDao.findAllOrders();
    }
}
