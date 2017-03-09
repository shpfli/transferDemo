/**
 * 
 */
package com.test.transfer.bean;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Hubery
 *
 */
public class Account {
	private String accountId;
	private long amount;
	private ReentrantLock lock;

	public Account() {
		super();
		this.lock = new ReentrantLock();
	}

	public Account(String accountId, long amount) {
		super();
		this.accountId = accountId;
		this.amount = amount;
		this.lock = new ReentrantLock();
	}

	public boolean tryLock() {
		return this.lock.tryLock();
	}

	public void unlock() {
		try {
			this.lock.unlock();
		} catch (IllegalMonitorStateException e) {
			// 未持有该锁时，进行释放会抛出IllegalMonitorStateException
		}
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", amount=" + amount + ", lock=" + lock + "]";
	}

}
