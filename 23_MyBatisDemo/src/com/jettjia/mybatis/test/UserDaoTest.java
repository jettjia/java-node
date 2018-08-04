package com.jettjia.mybatis.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.jettjia.mybatis.dao.UserDao;
import com.jettjia.mybatis.dao.impl.UserDaoImpl;
import com.jettjia.mybatis.pojo.User;

public class UserDaoTest {

    @Test
    public void testGetUserById() {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.getUserById(30);
        System.out.println(user);
    }

    @Test
    public void testGetUserByUserName() {
        UserDao userDao = new UserDaoImpl();
        List<User> users = userDao.getUserByUserName("张");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsertUser() {
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setUsername("李云");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("深圳");
        userDao.insertUser(user);
    }

}
