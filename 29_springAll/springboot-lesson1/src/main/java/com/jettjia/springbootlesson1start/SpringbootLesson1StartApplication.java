package com.jettjia.springbootlesson1start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource(locations = {"classpath:beans.xml"})
public class SpringbootLesson1StartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLesson1StartApplication.class, args);
	}
}
