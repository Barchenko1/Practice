//package com.example.practice.model;
//
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "Items")
//public class Item {
//    @Id
//    @Column(name="item_id")
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Long item_id;
//    @ManyToOne
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JoinColumn(name = "order_id")
//    private Order order_id;
//
//}
