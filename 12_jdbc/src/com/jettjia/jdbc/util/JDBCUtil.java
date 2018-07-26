package com.jettjia.jdbc.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

public class JDBCUtil {
	static String driverClass = null;
	static String url = null;
	static String user = null;
	static String password = null;
	
	// 类加载时候直接调用，载入jdbc.properties中，MySQL连接信息
	static {
		try {
			Properties properties = new Properties();
			// 使用类加载器，去读取src底下的资源文件。 后面在servlet
			InputStream inStream = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			properties.load(inStream);
			
			// 读取属性
			driverClass = properties.getProperty("driverClass");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接对象
	 * @return
	 */
	public static Connection getConn() {
		Connection conn = null;
		try {
			// 1 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2 获得数据库链接
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 释放资源
	 * @param rs
	 * @param st
	 * @param conn
	 */
	public static void release(ResultSet rs, Statement st, Connection conn) {
		closeResultSet(rs);
		closeStatement(st);
		closeConnection(conn);
	}
	
	/**
	 * 关闭 ResultSet
	 * @param rs
	 */
	private static void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rs = null;
		}
	}
	
	/**
	 * 关闭 Statement
	 * @param st
	 */
	private static void closeStatement(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			st = null;
		}
	}
	
	/**
	 * 关闭 Connection
	 * @param st
	 */
	private static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conn = null;
		}
	}
}
