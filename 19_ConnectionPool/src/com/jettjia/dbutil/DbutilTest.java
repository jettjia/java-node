package com.jettjia.dbutil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.jettjia.domain.Account;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbutilTest {

	@Test
	public void testDbutil() throws SQLException {
		// 创建数据库连接对象
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		// 创建QueryRunner对象
		QueryRunner queryRunner = new QueryRunner(dataSource);
		// 增
		//queryRunner.update("insert into account values(null, ?, ?)", "zhangsan", 100);
		
		// 删
		//queryRunner.update("delete from account where id=?", 4);
		
		// 改
		//queryRunner.update("update account set money=100000 where id=?", 1);
		
		// 查
		// 方式1 ，直接new接口的匿名实现类
		/*Account  account =  queryRunner.query("select * from account where id = ?", new ResultSetHandler<Account>(){

			@Override
			public Account handle(ResultSet rs) throws SQLException {
				Account account  =  new Account();
				while(rs.next()){
					String name = rs.getString("name");
					int money = rs.getInt("money");
					
					account.setName(name);
					account.setMoney(money);
				}
				return account;
			}
			 
		 }, 6);
		
		System.out.println(account.toString());*/
		
		// 方式2，BeanHandler 框架封装的方法，查单个对象
		/*Account account = queryRunner.query("select * from account where id = ?",
				new BeanHandler<Account>(Account.class) , 1);
		System.out.println(account.toString());*/
		
		// 方式2，BeanListHandler
		List<Account> list = queryRunner.query("select * from account", 
				new BeanListHandler<Account>(Account.class));
		for (Account account : list) {
			System.out.println(account.toString());
		}
	}

}
