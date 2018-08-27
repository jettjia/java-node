package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 显示页面
 */
@Controller
public class PageController {
    
    /**
     * 首页
     * @return
     */
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }
    
    /**
     * 展示其他页面，比如 /item-list
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}
