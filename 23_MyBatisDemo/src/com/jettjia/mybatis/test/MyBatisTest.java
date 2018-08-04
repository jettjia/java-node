package com.jettjia.mybatis.test;

import java.io.InputStream;
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
    public void getUserById() throws Exception {
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
    public void getUserByUserName() {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        /*List<User> users = sqlSession.selectList("user.getUserByUserName", "%王%");*/
        List<User> users = sqlSession.selectList("user.getUserByUserName", "王");
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
