package com.jettjia.mybatis.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.jettjia.mybatis.mapper.UserMapper;
import com.jettjia.mybatis.pojo.Order;
import com.jettjia.mybatis.pojo.QueryVo;
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

    @Test
    public void testGetUserByQueryVo() {
        // 1.加载配置得到SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        // 2. 获取UserMapper的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 3. 查询数据
        QueryVo vo = new QueryVo();
        User user2 = new User();
        user2.setUsername("张");
        vo.setUser(user2);
        List<User> users = userMapper.getUserByQueryVo(vo);
        // 4.处理获取到的数据
        for (User user : users) {
            System.out.println(user);
        }
        // 5. 关闭资源
        sqlSession.close();
    }

    @Test
    public void testGetUserCount() {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer userCount = userMapper.getUserCount();
        System.out.println("用户总数：" + userCount);
        sqlSession.close();
    }

    @Test
    public void testGetUserByPojo() {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("张");
        user.setSex("1");
        List<User> users = userMapper.getUserByPojo(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
        sqlSession.close();
    }

    @Test
    public void testGetUserByIds() {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        QueryVo vo = new QueryVo();
        vo.setIds(Arrays.asList(1, 26, 27, 30));
        List<User> users = userMapper.getUserByIds(vo);
        for (User user1 : users) {
            System.out.println(user1);
        }
        sqlSession.close();
    }
    
    @Test
    public void testGetUserOrderMap() {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.getUserOrderMap();
        for (User user : list) {
            System.out.println(user);
            for(Order order : user.getOrders()) {
                if (order.getId() != null) {
                    System.out.println("    此用户下的订单有：" + order);
                }
            }
        }
        sqlSession.close();
    }

}
