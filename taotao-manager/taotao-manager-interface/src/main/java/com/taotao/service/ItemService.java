package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;

/**
 * 商品处理的相关service
 * @author jettjia
 * @version 1.0
 */
public interface ItemService {
    
    /**
     * 根据当前的页码和每页的行数进行分页查询
     * @param page
     * @param rows
     * @return
     */
    public EasyUIDataGridResult getItemList(Integer page, Integer rows);
}
