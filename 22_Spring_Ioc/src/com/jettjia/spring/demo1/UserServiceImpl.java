package com.jettjia.spring.demo1;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	// 注入dao
	/*@Autowired
	@Qualifier("userDao22")*/
	@Resource
	private UserDao userDao;
	
	@Override
	public void save() {
		System.out.println("UserServiceImpl的save执行了...");
		// 调用UserDao里的方法
		userDao.save();
	}

}
