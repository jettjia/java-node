package com.jettjia.tx.demo3;

import org.springframework.transaction.annotation.Transactional;

/**
 * 转账的业务实现类
 */
@Transactional
public class AccountServiceImpl implements AccountService {
	// 注入accountDao
	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	/**
	 * 转账
	 * @param from 转出账号
	 * @param to 转入账号
	 * @param money 转账金额
	 */
	public void transfer(String from, String to, Double money) {
		accountDao.outMoney(from, money);
		//int i = 1 / 0;
		accountDao.inMoney(to, money);
	}
}
