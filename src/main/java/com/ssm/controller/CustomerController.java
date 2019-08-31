package com.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.entity.Customer;
import com.ssm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    //注入service对象
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/input")
    public String input() {
        return "input";
    }

    /*   *//*保存客户*//*
    @RequestMapping("/save")
    public String save(Customer customer) {
        System.out.println(customer);
        customerService.save(customer);
        return "succ";
    }*/

    /**
     * 查询所有数据，给页面返回json格式数据
     * easyui的datagrid组件，需要展示数提供json数据： [ {id:1,name:xxx},{id:1,name:xxx} ]
     */
    @RequestMapping("/list")
    @ResponseBody  // 用于转换对象为json
    public List<Customer> list() {
        //查询数据
        List<Customer> list = customerService.selectAll();
        return list;
    }

    //设计Map集合存储需要给页面的对象数据
    private Map<String, Object> result = new HashMap<>();

    /*
     * 分页查询
     * */
    @RequestMapping("/listByPage")
    @ResponseBody
    public Map<String, Object> listByPage(Integer page, Integer rows) {
        //设置分页参数
        PageHelper.startPage(page, rows);
        //查询所有数据
        List<Customer> list = customerService.selectAll();
        System.out.println(list);
        //使用PageInfo封装查询结果
        PageInfo<Customer> pageInfo = new PageInfo<Customer>(list);
        //从PageInfo对象取出查询结果
        //总记录数
        long total = pageInfo.getTotal();
        //当前页数据列表
        List<Customer> custrows = pageInfo.getList();
        result.put("total", total);
        result.put("rows", custrows);
        return result;
    }

    /*
     * 保存数据
     * */
    @RequestMapping("/save")
    @ResponseBody
    public Map<String, Object> save(Customer customer) {
        try {
            customerService.save(customer);
            result.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("msg", e.getMessage());
        }

        return result;
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Customer findById(Integer id) {
        Customer customer = customerService.findById(id);
        return customer;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map<String, Object> delete(Integer[] id) {
        try {
            customerService.delete(id);
            result.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        return result;
    }
}
