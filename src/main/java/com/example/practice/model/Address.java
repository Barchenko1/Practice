package com.example.practice.model;

import javax.persistence.*;

@Entity
@Table(name = "Addresses")
public class Address {
    @Id
    @Column(name="address_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long address_id;

    private String city;

    private String street;

    private String house;

    private String flat;

    public Address() {
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }
}
