package com.itheima.dubbodemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.dubbodemo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Reference
    private UserService userService;
    
    @RequestMapping("/showName")
    @ResponseBody
    public String showName() {
        return userService.getName();
    }
}
