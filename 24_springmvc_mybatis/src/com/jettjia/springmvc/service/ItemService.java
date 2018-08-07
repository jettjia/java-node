package com.jettjia.springmvc.service;

import java.util.List;

import com.jettjia.springmvc.pojo.Item;

/**
 * 商品信息业务逻辑接口
 */
public interface ItemService {
    
    /**
     * 获取商品列表
     * @return
     */
    List<Item> getItemList();
    
    /**
     * 根据ID查询商品详细
     * @param id
     * @return
     */
    Item getItemById(Integer id);
    
    /**
     * 根据ID更新商品
     * @param item
     */
    void updateItemById(Item item);
}
