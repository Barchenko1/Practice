package com.example.practice.dao;

import com.example.practice.model.Address;

import java.util.List;

public interface AddressDao {
    void createAddress(Address address);

    void updateAddress(Address address);

    void removeAddress(Address address);

    List<Address> findAllAddresses();

}
