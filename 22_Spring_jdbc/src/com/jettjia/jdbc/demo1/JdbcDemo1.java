package com.jettjia.jdbc.demo1;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcDemo1 {
	
	@Test
	public void test1() {
		// 创建链接池
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://10.0.0.150/jdbc_demo");
		dataSource.setUsername("jett");
		dataSource.setPassword("123456");
		// 创建jdbc模板
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		jdbcTemplate.update("insert into account values (null,?,?)", "jett",10000d);
	}
}
