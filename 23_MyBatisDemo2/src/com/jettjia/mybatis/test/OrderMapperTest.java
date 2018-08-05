package com.jettjia.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.jettjia.mybatis.mapper.OrderMapper;
import com.jettjia.mybatis.pojo.Order;
import com.jettjia.mybatis.pojo.OrderUser;
import com.jettjia.mybatis.utils.SqlSessionFactoryUtils;

public class OrderMapperTest {

    @Test
    public void testGetOrderList() {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderList = orderMapper.getOrderList();
        for (Order order : orderList) {
            System.out.println(order);
        }
        sqlSession.close();
    }
    
    @Test
    public void testGetOrderListMapper() {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderList = orderMapper.getOrderListMapper();
        for (Order order : orderList) {
            System.out.println(order);
        }
        sqlSession.close();
    }
    
    /**
     * 获取订单和用户信息，一对一关联：resultType使用
     */
    @Test
    public void testgetOrderUser() {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<OrderUser> orderList = orderMapper.getOrderUser();
        for (OrderUser order : orderList) {
            System.out.println(order);
        }
        sqlSession.close();
    }
    
    @Test
    public void testgetOrderUserMap() {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderList = orderMapper.getOrderUserMap();
        for (Order order : orderList) {
            System.out.println(order);
            System.out.println("此订单的用户为：" + order.getUser());
        }
        sqlSession.close();
    }

}
