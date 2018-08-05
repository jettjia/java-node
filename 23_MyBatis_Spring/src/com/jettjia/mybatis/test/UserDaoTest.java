package com.jettjia.mybatis.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jettjia.mybatis.dao.UserDao;
import com.jettjia.mybatis.pojo.User;

public class UserDaoTest {
    private ApplicationContext applicationContext;
    
    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }
    @Test
    public void testGetUserById() {
        UserDao userDao = applicationContext.getBean(UserDao.class);
        User user = userDao.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void testGetUserByUserName() {
        UserDao userDao = applicationContext.getBean(UserDao.class);
        List<User> list = userDao.getUserByUserName("张");
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsertUser() {
        UserDao userDao = applicationContext.getBean(UserDao.class);
        User user = new User();
        user.setUsername("王二小");
        user.setAddress("北京");
        user.setBirthday(new Date());
        user.setSex("1");
        userDao.insertUser(user);
    }

}
