package com.jettjia.spring.demo2;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{
	private CustomerDao customerDao;

	public CglibProxy(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	// 使用cglib获得代理对象
	public CustomerDao createProxy() {
		// 1.创建cglib的核心类对象
		Enhancer enhancer = new Enhancer();
		// 2.设置父类
		enhancer.setSuperclass(customerDao.getClass());
		// 3.设置回调（类似于InvocationHandler对象）
		enhancer.setCallback(this);
		// 4.创建代理对象
		CustomerDao proxy = (CustomerDao)enhancer.create();
		return proxy;
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		if ("save".equals(method.getName())) {
			System.out.println("权限验证调用");
			return methodProxy.invokeSuper(proxy, args);
		}
		return methodProxy.invokeSuper(proxy, args);
	}
}
