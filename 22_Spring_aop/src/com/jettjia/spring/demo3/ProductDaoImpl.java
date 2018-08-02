package com.jettjia.spring.demo3;

public class ProductDaoImpl implements ProductDao {

	@Override
	public void save() {
		System.out.println("ProductDaoImpl--save");
	}

	@Override
	public String delete() {
		System.out.println("ProductDaoImpl--delete");
		return "delete 返回";
	}

	@Override
	public void update() {
		System.out.println("ProductDaoImpl--update");
	}

	@Override
	public void find() {
		System.out.println("ProductDaoImpl--find");
		int i = 1 / 0;
	}

}
