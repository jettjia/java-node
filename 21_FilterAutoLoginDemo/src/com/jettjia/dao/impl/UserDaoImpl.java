package com.jettjia.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.jettjia.dao.UserDao;
import com.jettjia.domain.UserBean;
import com.jettjia.util.JDBCUtilC3P0;

public class UserDaoImpl implements UserDao {

	@Override
	public UserBean login(UserBean user) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtilC3P0.getDataSource());
		String sql = "select * from t_user where username = ? and password = ?";
		UserBean query = runner.query(sql, new BeanHandler<UserBean>(UserBean.class), user.getUsername(), user.getPassword());
		return query;
	}

}
