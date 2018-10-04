package com.jettjia.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.jettjia.springboot.mapper")
public class SpringbootLesson4MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLesson4MybatisApplication.class, args);
    }
}
