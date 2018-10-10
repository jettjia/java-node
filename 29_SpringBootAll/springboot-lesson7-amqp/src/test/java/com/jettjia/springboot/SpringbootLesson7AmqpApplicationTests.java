package com.jettjia.springboot;

import com.jettjia.springboot.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootLesson7AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 单播（点对点）
     */
    @Test
    public void contextLoads() {
        //Message需要自己构造一个;定义消息体内容和消息头
        //rabbitTemplate.send(exchage,routeKey,message);

        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq；
        //rabbitTemplate.convertAndSend(exchage,routeKey,object);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("hello world", 123, true));
        rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", map);
    }

    /**
     * 接收
     */
    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播
     */
    @Test
    public void sendMsg() {
        Book book = new Book("红楼梦", "曹雪芹");
        rabbitTemplate.convertAndSend("exchange.fanout", "", book);
    }

    @Autowired
    AmqpAdmin amqpAdmin;

    /**
     * 创建exchange
     */
    @Test
    public void createExchange() {
        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        System.out.println("创建完成");
    }

}
