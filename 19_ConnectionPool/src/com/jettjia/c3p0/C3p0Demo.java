package com.jettjia.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.jettjia.util.JDBCUtil;
import com.jettjia.util.JDBCUtilC3P0;

public class C3p0Demo {

	@Test
	public void test() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 链接
			conn = JDBCUtilC3P0.getConnection();
			String sql = "update account set money = 2333 where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(ps, conn);
		}
	}

}
