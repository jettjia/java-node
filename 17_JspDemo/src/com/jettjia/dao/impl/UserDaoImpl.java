package com.jettjia.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jettjia.dao.UserDao;
import com.jettjia.util.JDBCUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean login(String username, String password) {
		try {
			// 创建链接对象
			Connection conn = JDBCUtil.getConn();
			// 创建prepareStatement对象
			String sql = "select * from t_user where username=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			// 执行查询
			ResultSet rs = ps.executeQuery();
			return rs.next(); // 如果还有下一条，则表明查询到此条数据
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
