package com.jettjia.spring.demo5;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo5 {
	
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CollectionBean collectionBean = (CollectionBean)context.getBean("collectionBean");
		System.out.println(collectionBean);
	}
}
