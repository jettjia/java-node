package com.jettjia.spring.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo1 {
	
	@Test
	// 传统方式
	public void test1() {
		UserDao userDao = new UserDaoImpl();
		userDao.save();
	}
	
	@Test
	// Spring的IOC注解方式-注入属性
	public void test2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao)context.getBean("userDao");
		userDao.save();
	}
	
	@Test
	// Spring的IOC注解方式-注入对象
	public void test3() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)context.getBean("userService");
		userService.save();
	}
}
