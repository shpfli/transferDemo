package com.test.transfer.bean;

/**
 * @author Hubery
 *
 */
public class TransferRequest {
	/**
	 * 转出账户
	 */
	private String fromAccountId;

	/**
	 * 转入账户
	 */
	private String toAccountId;

	/**
	 * 转账金额
	 */
	private long amount;

	public TransferRequest() {
		super();
	}

	public TransferRequest(String fromAccountId, String toAccountId, long amount) {
		super();
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
	}

	public String getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(String fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public String getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(String toAccountId) {
		this.toAccountId = toAccountId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "TransferRequest [fromAccountId=" + fromAccountId + ", toAccountId=" + toAccountId + ", amount=" + amount
				+ "]";
	}

}
