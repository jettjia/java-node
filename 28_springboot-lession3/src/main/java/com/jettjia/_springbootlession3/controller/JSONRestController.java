package com.jettjia._springbootlession3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONRestController {

    @GetMapping(path = "/json/user")
    public User user() {

    }

}
