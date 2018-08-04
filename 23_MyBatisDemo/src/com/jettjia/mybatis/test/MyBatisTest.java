package com.jettjia.mybatis.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.jettjia.mybatis.pojo.User;
import com.jettjia.mybatis.utils.SqlSessionFactoryUtils;

public class MyBatisTest {
    
    @Test
    public void testGetUserById() throws Exception {
        // 1.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        // 2.创建核心配置文件的输入流
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 3.通过输入流创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = ssfb.build(inputStream);
        // 4.创建SqlSession对象
        
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 5.执行查询
        User user = sqlSession.selectOne("user.getUserById", 1);
        
        System.out.println(user);
        // 6.关闭
        sqlSession.close();
    }
    
    @Test
    public void testGetUserByUserName() {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        /*List<User> users = sqlSession.selectList("user.getUserByUserName", "%王%");*/
        List<User> users = sqlSession.selectList("user.getUserByUserName", "王");
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    
    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        User user = new User();
        user.setUsername("张飞3");
        user.setSex("1");
        user.setBirthday(new Date());
        user.setAddress("上海");
        sqlSession.insert("user.insertUser", user);
        System.out.println(user);
        // 提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    
    @Test
    public void testInsertUserUUID() {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        User user = new User();
        user.setUsername("张飞4");
        user.setSex("1");
        user.setBirthday(new Date());
        user.setAddress("上海");
        sqlSession.insert("user.insertUserUUID", user);
        System.out.println(user);
        // 提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    
    @Test
    public void testUpdateUser() {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        User user = new User();
        user.setUsername("张飞飞");
        user.setId(29);
        sqlSession.update("user.updateUser", user);
        System.out.println(user);
        // 提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    
    @Test
    public void testDeleteUser() {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        User user = new User();
        user.setId(29);
        sqlSession.update("user.deleteUser", user);
        System.out.println(user);
        // 提交事务
        sqlSession.commit();
        sqlSession.close();
    }
}
