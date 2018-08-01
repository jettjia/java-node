package com.jettjia.spring.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	private String name;
	
	@Value("张珊珊")
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void save() {
		System.out.println("UserDaoImpl执行了save方法..." + name);
	}

}
