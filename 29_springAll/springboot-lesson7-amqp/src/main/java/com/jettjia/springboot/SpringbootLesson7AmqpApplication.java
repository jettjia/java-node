package com.jettjia.springboot;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class SpringbootLesson7AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLesson7AmqpApplication.class, args);
    }
}
