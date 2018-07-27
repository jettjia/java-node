package com.jettjia.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.jettjia.jdbc.util.JDBCUtil;

public class TransactionTest {

	@Test
	public void testTransaction() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 创建连接对象
			conn = JDBCUtil.getConn();
			// 连接，事务默认就是自动提交的。 关闭自动提交。
			conn.setAutoCommit(false);
			// 创建prepareStatement对象
			String sql="update account set money=money-? where id=?";
			ps = conn.prepareStatement(sql);
			// 给A 减少100
			ps.setInt(1, 100);
			ps.setInt(2, 1);
			ps.executeUpdate();
			// 给B 增加100
			ps.setInt(1, -100);
			ps.setInt(2, 2);
			ps.executeUpdate();
			
			// 提交事务
			conn.commit();
			System.out.println("成功！！！");
		} catch (SQLException e) {
			// 失败，回滚
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JDBCUtil.release(rs, ps, conn);
		}
	}
	
	@Test
	public void testTransaction2() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 创建连接对象
			conn = JDBCUtil.getConn();
			// 连接，事务默认就是自动提交的。 关闭自动提交。
			conn.setAutoCommit(false);
			// 创建prepareStatement对象
			String sql="update account set money=money-? where id=?";
			ps = conn.prepareStatement(sql);
			// 给A 减少100
			ps.setInt(1, 100);
			ps.setInt(2, 1);
			ps.executeUpdate();
			// 假设出现错误
			int x = 10/0;
			// 给B 增加100
			ps.setInt(1, -100);
			ps.setInt(2, 2);
			ps.executeUpdate();
			
			// 提交事务
			conn.commit();
			System.out.println("成功！！！");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(rs, ps, conn);
		}
	}
	
	@Test
	public void testTransaction3() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 创建连接对象
			conn = JDBCUtil.getConn();
			// 连接，事务默认就是自动提交的。 关闭自动提交。
			conn.setAutoCommit(false);
			// 创建prepareStatement对象
			String sql="update account set money=money-? where id=?";
			ps = conn.prepareStatement(sql);
			// 给A 减少100
			ps.setInt(1, 100);
			ps.setInt(2, 1);
			ps.executeUpdate();
			
			// 假设出现错误
			int x = 1/0;
			
			// 给B 增加100
			ps.setInt(1, -100);
			ps.setInt(2, 2);
			ps.executeUpdate();
			
			// 提交事务
			conn.commit();
			System.out.println("成功！！！");
		} catch (SQLException e) {
			// 失败，回滚
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JDBCUtil.release(rs, ps, conn);
		}
	}

}
