package com.example.practice.service;

import com.example.practice.dto.OrderBookIdDto;
import com.example.practice.dto.OrderDto;
import com.example.practice.model.Order;
import com.example.practice.model.Title;

import java.util.List;

public interface OrderService {
    void createOrder(OrderBookIdDto order);

    void updateOrder(int id, OrderBookIdDto order);

    void removeOrder(Order order);

    List<OrderDto> findAllOrder();

    Order findTitleByBookCustomerId(int book_id, int customer_id);
}
