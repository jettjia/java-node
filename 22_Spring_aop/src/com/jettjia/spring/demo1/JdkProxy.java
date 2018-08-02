package com.jettjia.spring.demo1;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

public class JdkProxy implements InvocationHandler {
	
	private UserDao userDao;
	
	public JdkProxy(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 产生UserDao代理
	 */
	public UserDao createProxy() {
		UserDao userDaoProxy = (UserDao)Proxy.newProxyInstance(userDao.getClass().getClassLoader(), 
				userDao.getClass().getInterfaces(), this);
		return userDaoProxy;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if ("save".equals(method.getName())) {
			// 增强
			System.out.println("调用权限验证");
			return method.invoke(userDao, args);
		}
		return method.invoke(userDao, args);
	}

}
