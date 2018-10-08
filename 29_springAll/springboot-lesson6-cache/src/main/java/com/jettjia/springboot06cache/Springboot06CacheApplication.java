package com.jettjia.springboot06cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.jettjia.springboot06cache.mapper")
@SpringBootApplication
@EnableCaching
public class Springboot06CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot06CacheApplication.class, args);
    }
}
