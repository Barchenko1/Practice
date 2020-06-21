package com.example.practice.controller;

import com.example.practice.dto.OrderBookIdDto;
import com.example.practice.dto.OrderDto;
import com.example.practice.model.Order;
import com.example.practice.proposal.GenerateOrderPdfReport;
import com.example.practice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayInputStream;
import java.util.List;

import static com.example.practice.util.Constants.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected ModelAndView pageGet() {
        ModelAndView modelAndView = new ModelAndView();
        List<OrderDto> orderDtoList = orderService.findAllOrder();
        modelAndView.addObject("orderDtoList", orderDtoList);
        modelAndView.setViewName(ORDER_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createCustomerPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(CREATE_ORDER_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createCustomer(@ModelAttribute("orderBookIdDto") OrderBookIdDto orderBookIdDto) {
        orderService.createOrder(orderBookIdDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/order/");
        return modelAndView;
    }

    @RequestMapping(value = "/update/{book_id}/{customer_id}", method = RequestMethod.GET)
    public ModelAndView updateAuthorGet(@PathVariable("book_id") int book_id,
                                        @PathVariable("customer_id") int customer_id) {
        Order order = orderService.findTitleByBookCustomerId(book_id, customer_id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(UPDATE_ORDER_PAGE);
        modelAndView.addObject("order", order);
        modelAndView.addObject("book_id", book_id);
        modelAndView.addObject("customer_id", customer_id);
        return modelAndView;
    }

    @RequestMapping(value = "/update/{order_id}", method = RequestMethod.POST)
    public ModelAndView updateAuthorPost(@PathVariable("order_id") int order_id,
                                         @ModelAttribute("orderBookIdDto") OrderBookIdDto orderBookIdDto) {
        orderService.updateOrder(order_id, orderBookIdDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/order/");
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{book_id}/{customer_id}", method = RequestMethod.GET)
    public ModelAndView deleteAuthor(@PathVariable("book_id") int book_id,
                                     @PathVariable("customer_id") int customer_id) {
        Order order = orderService.findTitleByBookCustomerId(book_id, customer_id);
        orderService.removeOrder(order);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/order/");
        return modelAndView;
    }

    @RequestMapping(value = "/pdfReport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport() {

        List<OrderDto> orderDtoList = orderService.findAllOrder();

        ByteArrayInputStream bis = GenerateOrderPdfReport.pdfReport(orderDtoList);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=pdfReport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
