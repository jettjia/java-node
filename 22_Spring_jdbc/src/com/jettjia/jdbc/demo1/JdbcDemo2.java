package com.jettjia.jdbc.demo1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jettjia.jdbc.domain.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcDemo2 {
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Test
	/**
	 * 增
	 */
	public void test1() {
		jdbcTemplate.update("insert into account value(null, ?, ?)", "张三", 100d);
	}
	
	@Test
	/**
	 * 删
	 */
	public void test2() {
		jdbcTemplate.update("delete from account where id = ?", 1);
	}
	
	@Test
	/**
	 * 改
	 */
	public void test3() {
		jdbcTemplate.update("update account set name = ?, money = ? where id = ?", "张三三", 1000d, 2);
	}
	
	@Test
	/**
	 * 查询单个字段
	 */
	public void test4() {
		String name = jdbcTemplate.queryForObject("select name from account where id = ?", String.class, 2);
		System.out.println(name);
	}
	
	@Test
	/**
	 * 查询数目
	 */
	public void test5() {
		Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
		System.out.println(count);
	}
	
	@Test
	/**
	 * 查询一条数据到一个对象中
	 */
	public void test6() {
		Account account = jdbcTemplate.queryForObject("select * from account where id = ?", new MyRowMapper(), 2);
		System.out.println(account);
	}
	
	@Test
	/**
	 * 查询多条数据
	 */
	public void test7() {
		List<Account> list = jdbcTemplate.query("select * from account", new MyRowMapper());
		for (Account account : list) {
			System.out.println(account);
		}
	}
	
	class MyRowMapper implements RowMapper<Account> {

		@Override
		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
			Account account = new Account();
			account.setId(rs.getInt("id"));
			account.setName(rs.getString("name"));
			account.setMoney(rs.getDouble("money"));
			return account;
		}
	}
}
