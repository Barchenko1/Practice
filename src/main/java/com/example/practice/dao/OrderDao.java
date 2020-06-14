package com.example.practice.dao;

import com.example.practice.dto.OrderDto;
import com.example.practice.model.Order;

import java.util.List;

public interface OrderDao {
    void createOrder(Order order);

    void updateOrder(Order order);

    void removeOrder(Order order);

    List<OrderDto> findAllOrders();
}
