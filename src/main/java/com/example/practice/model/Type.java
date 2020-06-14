package com.example.practice.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Types")
public class Type {
    @Id
    @Column(name="type_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long type_id;

    @NotNull
    private String type_name;

    public Type() {
    }

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
}
