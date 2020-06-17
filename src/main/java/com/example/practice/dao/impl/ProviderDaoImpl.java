package com.example.practice.dao.impl;

import com.example.practice.dao.ProviderDao;
import com.example.practice.model.Provider;
import org.hibernate.SessionFactory;

public class ProviderDaoImpl implements ProviderDao {

    private SessionFactory sessionFactory;

    @Override
    public void createProvider(Provider provider) {
        if (provider != null)
        {
            throw new IllegalArgumentException("user is null");
        }
        sessionFactory.getCurrentSession().save(provider);

    }
}
