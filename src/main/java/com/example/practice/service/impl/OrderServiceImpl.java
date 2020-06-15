package com.example.practice.service.impl;

import com.example.practice.dao.OrderDao;
import com.example.practice.dto.OrderBookIdDto;
import com.example.practice.dto.OrderDto;
import com.example.practice.model.Book;
import com.example.practice.model.Customer;
import com.example.practice.model.Order;
import com.example.practice.service.BookService;
import com.example.practice.service.CustomerService;
import com.example.practice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private BookService bookService;

    @Autowired
    private CustomerService customerService;

    @Override
    public void createOrder(OrderBookIdDto orderBookIdDto) {
        Book book = bookService.findById(orderBookIdDto.getBook_id());
        Customer customer = customerService.findById(orderBookIdDto.getCustomer_id());
        Order order = new Order();
        order.setBook(book);
        order.setCustomer(customer);
        orderDao.createOrder(order);
    }

    @Override
    public void updateOrder(int id, OrderBookIdDto orderBookIdDto) {
        Book book = bookService.findById(orderBookIdDto.getBook_id());
        Customer customer = customerService.findById(orderBookIdDto.getCustomer_id());
        Order order = new Order();
        order.setOrder_id((long) id);
        order.setBook(book);
        order.setCustomer(customer);
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

    @Override
    public Order findTitleByBookCustomerId(int book_id, int customer_id) {
        return orderDao.findTitleByBookCustomerId(book_id, customer_id);
    }
}
