package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.service.ItemService;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;
    
    @RequestMapping(value="/item/list", method=RequestMethod.GET) // 映射请求地址和方法
    @ResponseBody // 指定返回json
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        
        // 1.引入服务 springmvc.xml
        // 2.注入服务 @Autowired
        // 3.调用服务的方法
        return itemService.getItemList(page, rows);
    }
}
