package com.example.practice.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @Column(name="book_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long book_id;
    private String title;
    private int price;
    private int circulation;
    private int advance;
    private Date public_date;

    public Book() {
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
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
}
