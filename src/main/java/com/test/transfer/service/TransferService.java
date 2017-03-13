package com.test.transfer.service;

import java.util.Collection;

import com.test.transfer.bean.Account;
import com.test.transfer.bean.TransferRequest;
import com.test.transfer.bean.TransferResponse;

/**
 * @author Hubery
 *
 */
public interface TransferService {

	/**
	 * @return 全部账户信息
	 */
	public Collection<Account> queryAll();

	/**
	 * 转账
	 * 
	 * @param req
	 *            转账入参，包含（转入帐号，转出帐号，转账金额）
	 * @return 转账结果（响应代码，响应消息）
	 */
	public TransferResponse transfer(TransferRequest req);
}
