package com.example.practice.model;

import javax.persistence.*;

@Entity
@Table(name = "Customers")
public class Customer {
    @Id
    @Column(name="customer_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long customer_id;
    private String f_name;
    private String l_name;
    private int age;
    private String login;
    private String password;
    private String email;
    private String phone;

    public Customer() {
    }

    public Customer(Long customer_id, String f_name, String l_name, int age, String login, String password, String email, String phone) {
        this.customer_id = customer_id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.age = age;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
