package com.jettjia.spring.demo4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo4 {
	
	@Test
	/**
	 * 构造方法方式的属性注入
	 */
	public void test1() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car car = (Car)applicationContext.getBean("car");
		System.out.println(car);
	}
	
	@Test
	/**
	 * set方法方式的属性注入
	 */
	public void test2() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car2 car2 = (Car2)applicationContext.getBean("car2");
		System.err.println(car2);
	}
	
	@Test
	/**
	 * set方法注入对象类型
	 */
	public void test3() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee employee = (Employee)applicationContext.getBean("employee");
		System.out.println(employee);
	}
}
