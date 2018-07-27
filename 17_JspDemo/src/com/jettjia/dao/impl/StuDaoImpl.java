package com.jettjia.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jettjia.dao.StuDao;
import com.jettjia.domain.Student;
import com.jettjia.util.JDBCUtil;

public class StuDaoImpl implements StuDao {

	@Override
	public List<Student> findAll() {
		ArrayList<Student> arrayList = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 创建链接
			conn = JDBCUtil.getConn();
			String sql = "select * from t_stu";
			// 创建 prepareStatement对象
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			// 将数据装入集合
			while(rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setAge(rs.getInt("age"));
				stu.setGender(rs.getInt("gender"));
				stu.setName(rs.getString("name"));
				stu.setAddress(rs.getString("address"));
				
				arrayList.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(rs, ps, conn);
		}
		return arrayList;
	}
}
