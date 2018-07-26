package com.jettjia.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jettjia.dao.ArticleDao;
import com.jettjia.util.JDBCUtil;

public class ArticleDaoImpl implements ArticleDao {

	@Override
	public void findAll() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 1 获取连接对象
			conn = JDBCUtil.getConn();
			// 2 创建statement对象
			st = conn.createStatement();
			// 3 执行sql
			rs = st.executeQuery("select id, title from j_article");
			// 4 遍历结果集
			while(rs.next()) {
				System.out.println(rs.getInt("id") + rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(rs, st, conn);
		}
	}

	@Override
	public void updateTitle(int id, String title) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "update j_article set title=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setInt(2, id);
			int rs = ps.executeUpdate();
			if (rs > 0) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(ps, conn);
		}
	}
}
