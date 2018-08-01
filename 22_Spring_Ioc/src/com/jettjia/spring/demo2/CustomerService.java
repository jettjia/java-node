package com.jettjia.spring.demo2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("customerService")
@Scope
public class CustomerService {
	
	@PostConstruct	// 相当于xml配置的init-method
	public void init() {
		System.out.println("CustomerService被初始化");
	}
	
	public void save() {
		System.out.println("CustomerService执行save方法");
	}
	
	@PreDestroy // 相当于xml配置的destroy-method
	public void destroy() {
		System.out.println("CustomerService被销毁");
	}
}
