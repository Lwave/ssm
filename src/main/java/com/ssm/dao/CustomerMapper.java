package com.ssm.dao;

import java.util.List;

import com.ssm.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper {
    /*
     * 保存数据
     * @param customer
     */
    public void save(Customer customer);

    /*
     *
     * 查询所有用户
     *
     * */
    public List<Customer> selectAll();

    /*
     * 通过id查询用户
     * */
    Customer findById(Integer id);

    /*
     * 更新用户
     * */
    void update(Customer customer);

    /*
     * 删除用户
     * */
    void delete(Integer[] id);
}
