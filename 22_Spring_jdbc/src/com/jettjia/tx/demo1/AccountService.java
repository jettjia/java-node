package com.jettjia.tx.demo1;

/**
 * 转账的业务层接口
 */
public interface AccountService {
	
	/**
	 * 转账
	 * @param from 转出账号
	 * @param to 转入账号
	 * @param money 转账金额
	 */
	public void transfer(String from , String to, Double money);
}
