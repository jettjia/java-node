package com.jettjia.spring.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo3 {
	
	@Test
	/**
	 * XML配置和注解配置整合
	 */
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductService productService = (ProductService)context.getBean("productService");
		productService.save();
	}
}
