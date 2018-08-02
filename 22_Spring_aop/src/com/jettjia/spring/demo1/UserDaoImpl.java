package com.jettjia.spring.demo1;

public class UserDaoImpl implements UserDao {

	@Override
	public void save() {
		System.out.println("UserDaoImpl--save");
	}

	@Override
	public void update() {
		System.out.println("UserDaoImpl--update");
	}

	@Override
	public void delete() {
		System.out.println("UserDaoImpl--delete");
	}

	@Override
	public void find() {
		System.out.println("UserDaoImpl--find");
	}

}
