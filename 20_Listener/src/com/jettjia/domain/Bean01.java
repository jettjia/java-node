package com.jettjia.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Bean01 implements HttpSessionBindingListener {
	private String name;

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println(name + "被加到session中了");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println(name + "被session踢出来了");
	}
	
	public Bean01(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
