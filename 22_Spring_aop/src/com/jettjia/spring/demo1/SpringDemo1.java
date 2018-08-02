package com.jettjia.spring.demo1;

import org.junit.Test;

public class SpringDemo1 {
	
	@Test
	/**
	 * 传统方式
	 */
	public void test1() {
		UserDao userDao = new UserDaoImpl();
		userDao.save();
		userDao.update();
		userDao.delete();
		userDao.find();
	}
	
	@Test
	/**
	 * jdk动态代理实现
	 */
	public void test2() {
		UserDao userDao = new UserDaoImpl();
		// 创建代理
		UserDao jdkProxy = new JdkProxy(userDao).createProxy();
		jdkProxy.save();
		jdkProxy.update();
		jdkProxy.delete();
		jdkProxy.find();
	}
}
