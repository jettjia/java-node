package com.jettjia.spring.demo2;

import org.junit.Test;

public class SpringDemo2 {
	
	@Test
	public void test1() {
		CustomerDao customerDao = new CustomerDao();
		CustomerDao cglibProxy = new CglibProxy(customerDao).createProxy();
		cglibProxy.save();
		cglibProxy.update();
		cglibProxy.delete();
		cglibProxy.find();
	}
}
