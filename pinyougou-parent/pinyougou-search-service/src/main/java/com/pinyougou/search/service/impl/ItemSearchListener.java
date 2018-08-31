package com.pinyougou.search.service.impl;

import java.util.List;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.search.service.ItemSearchService;

@Component
public class ItemSearchListener implements MessageListener {
    
    @Autowired
    private ItemSearchService itemSearchService;

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();
            List<TbItem> list = JSON.parseArray(text , TbItem.class);
            for (TbItem item : list) {
                Map specMap = JSON.parseObject(item.getSpec());
                item.setSpecMap(specMap);//给带注解的字段赋值
            }
            itemSearchService.importList(list);
            System.out.println("成功导入到索引库");
        } catch (JMSException e) {
            e.printStackTrace();
        }
        
    }

}
