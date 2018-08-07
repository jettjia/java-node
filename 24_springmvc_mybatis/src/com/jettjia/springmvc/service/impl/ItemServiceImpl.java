package com.jettjia.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jettjia.springmvc.mapper.ItemMapper;
import com.jettjia.springmvc.pojo.Item;
import com.jettjia.springmvc.service.ItemService;

/**
 * 商品信息业务逻辑实现
 */
@Service
public class ItemServiceImpl implements ItemService {
    
    @Autowired
    private ItemMapper itemMapper;
    
    @Override
    public List<Item> getItemList() {
        // 从数据库查询商品列表
        return itemMapper.selectByExample();
    }

    @Override
    public Item getItemById(Integer id) {
        return itemMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateItemById(Item item) {
        itemMapper.updateByPrimaryKeySelective(item);
    }

}
