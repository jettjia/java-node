package com.jettjia.jdbc.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jettjia.jdbc.util.JDBCUtil;

public class MainTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 1 获取连接对象
			conn = JDBCUtil.getConn();
			// 2 根据连接对象，得到statement
			st = conn.createStatement();
			// 3 执行sql语句，返回ResultSet
			rs = st.executeQuery("select id, name from j_cate");
			// 4 处理返回结果集
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				System.out.println(id + " " + name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源，无论如何都会执行如下代码
			JDBCUtil.release(rs, st, conn);
		}
	}
}
