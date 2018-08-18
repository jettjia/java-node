package com.taotao.test.pagehelper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

public class TestPageHelper {

    @Test
    public void testHelper() {
        // 1.初始化容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        // 2.获取mapper的代理对象
        TbItemMapper itemMapper = ac.getBean(TbItemMapper.class);
        // 3.设置分页信息
        PageHelper.startPage(1, 3); // 紧跟着的第一个查询才会被分页
        // 4.调用mapper的方法查询数据
        TbItemExample example = new TbItemExample(); // 设置查询条件使用
        List<TbItem> list = itemMapper.selectByExample(example); // select * from tb_item;
        List<TbItem> list2 = itemMapper.selectByExample(example); // select * from tb_item;
        // 5.获取分页信息
        PageInfo<TbItem> info = new PageInfo<>(list);
        
        System.out.println("第一个分页的list的集合长度"+list.size());
        System.out.println("第二个分页的list的集合长度"+list2.size());
        System.out.println("查询的总记录数数："+info.getTotal());
        // 6.变量结果集，打印测试
        for (TbItem tbItem : list) {
            System.out.println(tbItem.getId() + "--" + tbItem.getTitle());
        }
    }

}
