package com.jettjia.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.jettjia.mybatis.dao.UserDao;
import com.jettjia.mybatis.pojo.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    @Override
    public User getUserById(Integer id) {
        SqlSession sqlSession = super.getSqlSession();
        User user = sqlSession.selectOne("user.getUserById", id);
        // 不要关闭 SqlSession
        return user;
    }

    @Override
    public List<User> getUserByUserName(String name) {
        SqlSession sqlSession = super.getSqlSession();
        List<User> list = sqlSession.selectList("user.getUserByUserName", name);
        // 不要关闭 SqlSession
        return list;
    }

    @Override
    public void insertUser(User user) {
        SqlSession sqlSession = super.getSqlSession();
        sqlSession.insert("user.insertUser", user);
        // 不要提交事务，用Spring管理
        // 不要关闭SqlSession
    }

}
