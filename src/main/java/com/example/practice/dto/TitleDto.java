package com.example.practice.dto;

public class TitleDto {
    private int author_pay;
    private String title;
    private String f_name;

    public TitleDto() {
    }

    public int getAuthor_pay() {
        return author_pay;
    }

    public void setAuthor_pay(int author_pay) {
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
