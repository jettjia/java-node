package com.jettjia.springmvc.mapper;

import java.util.List;

import com.jettjia.springmvc.pojo.Item;

public interface ItemMapper {
    /**
     * 查询所有的商品
     * @return
     */
    List<Item> selectByExample();
    
    /**
     * 根据主键ID查询商品详细
     * @param id
     * @return
     */
    Item selectByPrimaryKey(Integer id);
    
    /**
     * 根据主键ID，修改商品信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Item record);
}
