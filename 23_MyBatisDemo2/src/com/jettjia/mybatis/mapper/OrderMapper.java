package com.jettjia.mybatis.mapper;

import java.util.List;

import com.jettjia.mybatis.pojo.Order;
import com.jettjia.mybatis.pojo.OrderUser;

/**
 * 订单持久化接口
 */
public interface OrderMapper {
    
    /**
     * 获取订单列表
     * @return
     */
    List<Order> getOrderList();
    
    /**
     * 获取订单列表，resultMap映射
     * @return
     */
    List<Order> getOrderListMapper();
    
    /**
     * 获取订单和用户信息，一对一关联：resultType使用
     * @return
     */
    List<OrderUser> getOrderUser();
    
    /**
     * 获取订单和用户信息，一对一关联：resultMap使用
     * @return
     */
    List<Order> getOrderUserMap();
    
}
