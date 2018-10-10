package com.jettjia.springboot.controller;

import com.jettjia.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController {

    /*@RequestMapping({"/", "index.html"})
    public String index() {
        return "index";
    }*/

    @RequestMapping("success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好</h1>");
        return "success";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public  String hello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello World";
    }
}
