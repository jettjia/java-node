package com.jettjia.spring.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo2 {
	
	/**
	 * 生命周期的配置
	 */
	@Test
	public void test1() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao  customerDao = (CustomerDao) applicationContext.getBean("customerDao");
		customerDao.save();
		applicationContext.close();
	}
	
	/**
	 * Bean作用范围的配置
	 */
	@Test
	public void test2() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao  customerDao1 = (CustomerDao) applicationContext.getBean("customerDao");
		System.out.println(customerDao1);
		CustomerDao  customerDao2 = (CustomerDao) applicationContext.getBean("customerDao");
		System.out.println(customerDao2);
		System.out.println(customerDao1==customerDao2);
		applicationContext.close();
	}
}
