package com.atguigu.myrule;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configurable
public class MySelfRule {
    
    @Bean
    public IRule myRule () {
        //return new RandomRule(); // Ribbon默认是轮询，我们这里自定义随机
        return new RandomRule_ZY(); // 自定义规则
    }
}
