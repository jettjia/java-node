package com.jettjia.dao;

import java.sql.SQLException;

import com.jettjia.domain.UserBean;

public interface UserDao {
	UserBean login(UserBean user) throws SQLException;
}
