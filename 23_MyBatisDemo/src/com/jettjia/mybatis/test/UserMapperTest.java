package com.jettjia.mybatis.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.jettjia.mybatis.mapper.UserMapper;
import com.jettjia.mybatis.pojo.User;
import com.jettjia.mybatis.utils.SqlSessionFactoryUtils;

public class UserMapperTest {

    @Test
    public void testGetUserById() {
        // 1.加载配置得到SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        // 2. 获取UserMapper的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 3. 查询数据
        User user = userMapper.getUserById(30);
        // 4.处理获取到的数据
        System.out.println(user);
        // 5. 关闭资源
        sqlSession.close();
    }

    @Test
    public void testGetUserByUserName() {
        // 1.加载配置得到SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        // 2. 获取UserMapper的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 3. 查询数据
        List<User> users = userMapper.getUserByUserName("张");
        // 4.处理获取到的数据
        for (User user : users) {
            System.out.println(user);
        }
        // 5. 关闭资源
        sqlSession.close();
    }

    @Test
    public void testInsertUser() {
        // 1.加载配置得到SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        // 2. 获取UserMapper的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 3. 添加数据
        User user = new User();
        user.setUsername("赵云");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("武汉");
        userMapper.insertUser(user);
        // 4.提交事务
        sqlSession.commit();
        // 5.关闭资源
        sqlSession.close();
    }

}
