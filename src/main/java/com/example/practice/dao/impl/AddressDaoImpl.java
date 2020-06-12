package com.example.practice.dao.impl;

import com.example.practice.dao.AddressDao;
import com.example.practice.model.Address;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.isNull;

@Repository
@Transactional
public class AddressDaoImpl implements AddressDao {

    private static final String FIND_ALL_ADDRESSES = "SELECT * from Addresses";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createAddress(Address address) {
        if (isNull(address)) {
            throw new IllegalArgumentException("address is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .save(address);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAddress(Address address) {
        if (isNull(address)) {
            throw new IllegalArgumentException("address is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .update(address);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeAddress(Address address) {
        if (isNull(address)) {
            throw new IllegalArgumentException("address is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .delete(address);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Address> findAllAddresses() {
        Query query = sessionFactory.getCurrentSession().createQuery(FIND_ALL_ADDRESSES);
        if (query.list().isEmpty()) {
            return null;
        }
        return (List<Address>) query.list();
    }

}
