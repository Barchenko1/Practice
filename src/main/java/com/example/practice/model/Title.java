//package com.example.practice.model;
//
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "Titles")
//public class Title {
//    @Id
//    @Column(name="title_id")
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Long title_id;
//    @ManyToOne
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JoinColumn(name = "author_id")
//    private Author author_id;
//
//    private int author_pay;
//}
