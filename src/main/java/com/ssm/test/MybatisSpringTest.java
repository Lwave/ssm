package com.ssm.test;

import com.ssm.dao.CustomerMapper;
import com.ssm.entity.Customer;
import com.ssm.service.CustomerService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resources;
import java.io.InputStream;

/*
 * mybatis和spring整合
 * */
public class MybatisSpringTest {
    @Test
    public void save() {
        //1.加载spring配置
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取对象
        CustomerService customerService = (CustomerService) ac.getBean("customerService");
        //3.调用方法
        Customer customer = new Customer();
        customer.setName("老na");
        customer.setGender("男");
        customer.setTelephone("15935234962");
        customer.setAddress("青丘");
        customerService.save(customer);

    }

}

