package com.example.practice.controller;

import com.example.practice.model.Address;
import com.example.practice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping(value = "/create")
    public void createAddress(@RequestBody Address address) {
        addressService.createAddress(address);
    }
}
