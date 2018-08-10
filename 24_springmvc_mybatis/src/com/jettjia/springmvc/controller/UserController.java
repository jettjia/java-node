package com.jettjia.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户处理器
 */
@Controller
@RequestMapping("user")
public class UserController {
    
    /**
     * 登录页面
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }
    
    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("login")
    public String login(String username, String password, HttpSession session) {
        // 登录验证，这里直接简写了，自行补齐
        if (username.equals("admin")) {
            session.setAttribute("username", username);
            return "redirect:/itemList.action";
        }
        return "login";
    }
}
