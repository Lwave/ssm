package com.ssm.service.impl;

import java.util.List;

import com.ssm.dao.CustomerMapper;
import com.ssm.entity.Customer;
import com.ssm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

    //注入Mapper接口对象
    @Autowired
    private CustomerMapper customerMapper;


    public void save(Customer customer) {
        //判断是添加还是修改
        if (customer.getId() != null) {
            //修改
            customerMapper.update(customer);
        } else {
            //添加
            customerMapper.save(customer);
        }
    }

    @Override
    public List<Customer> selectAll() {
        return customerMapper.selectAll();
    }

    @Override
    public Customer findById(Integer id) {

        return customerMapper.findById(id);
    }

    @Override
    public void delete(Integer[] id) {
        customerMapper.delete(id);
    }
}
