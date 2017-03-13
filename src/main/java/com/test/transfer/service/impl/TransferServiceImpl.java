package com.test.transfer.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.test.transfer.bean.Account;
import com.test.transfer.bean.TransferRequest;
import com.test.transfer.bean.TransferResponse;
import com.test.transfer.service.TransferService;

/**
 * @author Hubery
 *
 */
@Service("transferService")
public class TransferServiceImpl implements TransferService {
	// 考虑到本测试中，不会新增或删除新的账户，故无需使用ConcurrentHashMap
	private static final Map<String, Account> DB_DEMO = new HashMap<>();

	static {
		// 模拟装载数据，以初始化账户数据
		DB_DEMO.put("zhangsan", new Account("zhangsan", 10000000L));
		DB_DEMO.put("lisi", new Account("lisi", 0L));
		DB_DEMO.put("wangwu", new Account("wangwu", Math.round(Math.random() * 100000)));
		DB_DEMO.put("zhaoliu", new Account("zhaoliu", Math.round(Math.random() * 100000)));
		// System.out.println(db);
	}

	/**
	 * @return 全部账户信息
	 */
	public Collection<Account> queryAll() {
		return DB_DEMO.values();
	}

	/**
	 * 转账
	 * 
	 * @param req
	 *            转账入参，包含（转入帐号，转出帐号，转账金额）
	 * @return 转账结果（响应代码，响应消息）
	 */
	public TransferResponse transfer(TransferRequest req) {
		Account fromAccount = DB_DEMO.get(req.getFromAccountId());// 转入账户
		Account toAccount = DB_DEMO.get(req.getToAccountId());// 转出账户

		TransferResponse rsp = null;
		if (fromAccount == null) {
			rsp = new TransferResponse("-1", "转出账户不存在！");
		} else if (toAccount == null) {
			rsp = new TransferResponse("-2", "转入账户不存在！");
		} else {
			// 尝试锁定要操作的两个账户
			while (!(fromAccount.tryLock() && toAccount.tryLock())) {
				// 锁定失败，释放已获得的锁，并让步其他线程
				fromAccount.unlock();
				// toAccount.unlock();
				// //由于toAccount.tryLock()在后，如果toAccount锁定成功，则fromAccout也已锁定成功。所以此处toAccount肯定尚未锁定。故无需解锁
				Thread.yield();// 让步其他线程
			}

			// 同时拥有两个账户的锁，进行转账操作
			try {
				rsp = this.transfer(fromAccount, toAccount, req.getAmount());
			} finally {
				// 释放两个账户上的锁
				fromAccount.unlock();
				toAccount.unlock();
			}

		}

		return rsp;
	}

	/**
	 * 转账操作
	 * 
	 * @param fromAccount
	 *            转出帐户
	 * @param toAccount
	 *            转入账户
	 * @param amount
	 *            金额
	 * @return
	 */
	private TransferResponse transfer(Account fromAccount, Account toAccount, long amount) {
		long fromAccountBalance = fromAccount.getAmount();// 转出帐户余额
		long toAccountBalance = toAccount.getAmount();// 转入账户余额
		if (fromAccountBalance < amount) {
			return new TransferResponse("-3", "对不起，您的账户余额不足！");
		}

		fromAccount.setAmount(fromAccountBalance - amount);
		toAccount.setAmount(toAccountBalance + amount);

		return new TransferResponse("0", "转账成功！");
	}

}
