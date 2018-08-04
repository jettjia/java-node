package com.jettjia.tx.demo1;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 转账的业务实现类
 */
public class AccountServiceImpl implements AccountService {
	// 注入accountDao
	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	// 注入事务管理模板
	private TransactionTemplate trsactionTemplate;

	public void setTrsactionTemplate(TransactionTemplate trsactionTemplate) {
		this.trsactionTemplate = trsactionTemplate;
	}


	@Override
	/**
	 * 转账
	 * @param from 转出账号
	 * @param to 转入账号
	 * @param money 转账金额
	 */
	public void transfer(final String from, final String to, final Double money) {
		trsactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
				accountDao.outMoney(from, money);
				int i = 1 / 0;
				accountDao.inMoney(to, money);
			}
		});
	}

}
