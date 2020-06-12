package com.example.practice.service;

import com.example.practice.model.Address;

import java.util.List;

public interface AddressService {
    void createAddress(Address address);

    void updateAddress(Address address);

    void removeAddress(Address address);

    List<Address> findAllAddresses();
}
