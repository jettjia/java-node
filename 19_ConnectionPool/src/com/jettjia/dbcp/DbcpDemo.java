package com.jettjia.dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.junit.Test;
import com.jettjia.util.JDBCUtil;

public class DbcpDemo {
	
	@Test
	public void testDbcp() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "update account set money = 10000 where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(ps, conn);
		}
	}
}
