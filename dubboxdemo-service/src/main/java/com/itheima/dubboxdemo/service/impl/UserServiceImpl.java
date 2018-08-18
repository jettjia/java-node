package com.itheima.dubboxdemo.service.impl;

import com.itheima.dubbodemo.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getName() {
        return "jett";
    }

}
