package com.example.practice.dto;

public class TitleDto {

    private int book_id;
    private int author_id;
    private String title;
    private int price;
    private int circulation;
    private String f_name;
    private String l_name;
    private int author_pay;
    private Number income;

    public TitleDto() {
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
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

    public int getAuthor_pay() {
        return author_pay;
    }

    public void setAuthor_pay(int author_pay) {
        this.author_pay = author_pay;
    }

    public Number getIncome() {
        return income;
    }

    public void setIncome(Number income) {
        this.income = income;
    }
}
