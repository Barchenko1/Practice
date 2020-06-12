package com.example.practice.model;

import javax.persistence.Entity;

public class TestDto {
    private Long author_pay;
    private String title;
    private String f_name;

    public TestDto() {
    }

    public Long getAuthor_pay() {
        return author_pay;
    }

    public void setAuthor_pay(Long author_pay) {
        this.author_pay = author_pay;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }
}
