package com.example.practice.service;

import com.example.practice.dto.OrderDto;
import com.example.practice.model.Order;
import com.example.practice.model.Title;

import java.util.List;

public interface OrderService {
    void createOrder(Order order);

    void updateOrder(Order order);

    void removeOrder(Order order);

    List<OrderDto> findAllOrder();
}
