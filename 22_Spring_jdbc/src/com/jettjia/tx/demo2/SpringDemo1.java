package com.jettjia.tx.demo2;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试转账的环境
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx2.xml")
public class SpringDemo1 {
	
	@Resource(name="accountService")
	private AccountService accountService;
	
	@Test
	public void test1() {
		accountService.transfer("张三三", "张三", 50d);
	}
}
