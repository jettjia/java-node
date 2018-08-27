package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
    
    @Autowired
    private TbItemMapper mapper;
    @Override
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        // 1.设置分页的信息，使用pagehelper
        page = page == null ? 1 : page;
        rows = rows == null ? 30 : rows;
        PageHelper.startPage(page, rows);
        // 2.输入mapper,@Autowired
        // 3.创建example对象
        TbItemExample example = new TbItemExample();
        // 4.根据mapper调用查询所有数据的方法
        List<TbItem> list = mapper.selectByExample(example);
        // 5.获取分页信息
        PageInfo<TbItem> info = new PageInfo<>(list);
        // 6.封装到EasyUIDataGridResult
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal((int)info.getTotal());
        result.setRows(info.getList());
        // 7.返回
        return result;
    }
}
