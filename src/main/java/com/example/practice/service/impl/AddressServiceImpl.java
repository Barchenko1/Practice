package com.example.practice.service.impl;

import com.example.practice.dao.AddressDao;
import com.example.practice.model.Address;
import com.example.practice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    public void createAddress(Address address) {
        addressDao.createAddress(address);
    }

    @Override
    public void updateAddress(Address address) {
        addressDao.updateAddress(address);
    }

    @Override
    public void removeAddress(Address address) {
        addressDao.removeAddress(address);
    }

    @Override
    public List<Address> findAllAddresses() {
        return addressDao.findAllAddresses();
    }
}
