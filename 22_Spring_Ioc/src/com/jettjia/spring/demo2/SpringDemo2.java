package com.jettjia.spring.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo2 {
	
	@Test
	/**
	 * 注解配置的生命周期
	 */
	public void test1() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService = (CustomerService)context.getBean("customerService");
		customerService.save();
		context.close();
	}
	
	@Test
	/**
	 * 注解配置的作用范围
	 */
	public void test2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService1 = (CustomerService)context.getBean("customerService");
		System.out.println(customerService1);
		CustomerService customerService2 = (CustomerService)context.getBean("customerService");
		System.out.println(customerService2);
	}
}
