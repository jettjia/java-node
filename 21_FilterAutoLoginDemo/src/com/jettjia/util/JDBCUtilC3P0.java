package com.jettjia.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;

public class JDBCUtilC3P0 {
	private static ComboPooledDataSource dataSource = null;

	static {
		dataSource = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * 获取连接对象
	 * 
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConn() throws SQLException {
		return dataSource.getConnection();
	}

	/**
	 * 释放资源
	 * 
	 * @param rs
	 * @param st
	 * @param conn
	 */
	public static void release(ResultSet rs, Statement st, Connection conn) {
		closeResultSet(rs);
		closeStatement(st);
		closeConnection(conn);
	}

	public static void release(Statement st, Connection conn) {
		closeStatement(st);
		closeConnection(conn);
	}

	private static void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs = null;
		}
	}

	private static void closeStatement(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st = null;
		}
	}

	private static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
}