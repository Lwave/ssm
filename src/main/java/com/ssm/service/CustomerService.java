package com.ssm.service;

import java.util.List;

import com.ssm.entity.Customer;


public interface CustomerService {

    public void save(Customer customer);

    public List<Customer> selectAll();

    Customer findById(Integer id);

    void delete(Integer[] id);
}
