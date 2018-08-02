package com.jettjia.spring.demo1;

public class OrderDao {

	public void save() {
		System.out.println("OrderDao---save");
	}

	public String delete() {
		System.out.println("OrderDao---delete");
		return "返回参数";
	}

	public void update() {
		System.out.println("OrderDao---update");
	}

	public void find() {
		System.out.println("OrderDao---find");
		int i = 1 / 0;
	}
}
