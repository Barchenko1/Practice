package com.example.practice.model;

import javax.persistence.*;

@Entity
@Table(name = "Providers")
public class Provider {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String phone;
}
