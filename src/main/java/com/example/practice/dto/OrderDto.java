package com.example.practice.dto;

import java.util.Date;

public class OrderDto {

    private String title;
    private int price;
    private int circulation;
    private int advance;
    private Date public_date;
    private String f_name;
    private String l_name;
    private String email;

    public OrderDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCirculation() {
        return circulation;
    }

    public void setCirculation(int circulation) {
        this.circulation = circulation;
    }

    public int getAdvance() {
        return advance;
    }

    public void setAdvance(int advance) {
        this.advance = advance;
    }

    public Date getPublic_date() {
        return public_date;
    }

    public void setPublic_date(Date public_date) {
        this.public_date = public_date;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
