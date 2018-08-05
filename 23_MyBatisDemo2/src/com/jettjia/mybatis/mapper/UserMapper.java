package com.jettjia.mybatis.mapper;

import java.util.List;

import com.jettjia.mybatis.pojo.Order;
import com.jettjia.mybatis.pojo.QueryVo;
import com.jettjia.mybatis.pojo.User;

/**
 * 用户持久化接口
 * @author ThinkPad
 */
public interface UserMapper {
    
    /**
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    User getUserById(Integer id);
    
    /**
     * 根据用户名查找用户列表
     * @param name
     * @return
     */
    List<User> getUserByUserName(String name);
    
    /**
     * 添加用户
     * @param user
     */
    void insertUser(User user);
    
    /**
     * 传递包中的pojo对象，获取用户信息
     * @param vo
     * @return
     */
    List<User> getUserByQueryVo(QueryVo vo);
    
    /**
     * 获取用户总数
     * @return
     */
    Integer getUserCount();
    
    /**
     * 获取用户--if动态sql演示
     * @param user
     * @return
     */
    List<User> getUserByPojo(User user);
    
    /**
     * 获取指定id的用户信息--foreach动态sql演示
     * @param vo
     * @return
     */
    List<User> getUserByIds(QueryVo vo);
    
    /**
     * 获得用户的所有订单--一对多演示
     * @return
     */
    List<User> getUserOrderMap();
}
