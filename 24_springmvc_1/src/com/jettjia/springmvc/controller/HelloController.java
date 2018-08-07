package com.jettjia.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    
    @RequestMapping("hello")
    public ModelAndView hello() {
        // 创建ModelAndView对象
        ModelAndView mav = new ModelAndView();
        // 设置模型数据
        mav.addObject("msg", "hello springmvc");
        // 设置视图名字
        //mav.setViewName("/WEB-INF/jsp/hello.jsp");
        mav.setViewName("hello");
        return mav;
    }
}
