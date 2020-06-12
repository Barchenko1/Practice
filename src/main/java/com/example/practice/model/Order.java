package com.example.practice.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @Column(name="order_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long order_id;

    private Date date;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "book_id")
    private Book book;
}
