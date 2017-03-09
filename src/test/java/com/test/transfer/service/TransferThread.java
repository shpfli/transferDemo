package com.test.transfer.service;

import com.test.transfer.bean.TransferRequest;
import com.test.transfer.bean.TransferResponse;

public class TransferThread implements Runnable {
	private TransferService service;

	public TransferThread(TransferService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		TransferRequest req = new TransferRequest("zhangsan", "lisi", 10);
		// 测试转账10000次，每次10元
		for (int i = 0; i < 10000; i++) {
			TransferResponse rsp = service.transfer(req);
			if (!"0".equals(rsp.getResponseCode())) {
				System.out.println("转账失败，转账终止！ errorMsg:" + rsp.getResponseMsg());
				return;
			}
		}
		System.out.println("10000次转账结束！");
	}

}
