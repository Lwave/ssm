package com.ssm.test;

import com.ssm.dao.CustomerMapper;
import com.ssm.entity.Customer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import javax.annotation.Resources;
import java.io.InputStream;

/*
* MybatisTest单独使用，只配置了持久层的mybatis
* */
public class MybatisTest {
    @Test
    public void save() {
        //1.创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //加载sqlMapConfig.xml
        InputStream is = Resources.class.getResourceAsStream("/sqlMapConfig.xml");
        System.out.println(is);
        //2.创建SqlSessionFactory
        SqlSessionFactory factory = builder.build(is);
        //3.打开SqlSession
        SqlSession sqlSession = factory.openSession();
        //获取Mapper接口对象
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        //操作
        Customer customer = new Customer();
        customer.setName("白hong");
        customer.setGender("女");
        customer.setTelephone("021-0234-2234");
        customer.setAddress("天津大学城");
        customerMapper.save(customer);
        //提交事务
        sqlSession.commit();
        //关闭事务
        sqlSession.close();
    }

}

