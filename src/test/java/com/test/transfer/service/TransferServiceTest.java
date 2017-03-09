/**
 * 
 */
package com.test.transfer.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.test.transfer.service.impl.TransferServiceImpl;

/**
 * @author Hubery
 *
 */
public class TransferServiceTest {
	/*
	 * zhangsan帐号初始有：10000000， lisi：0，100个线程同时执行10000次转账，每次转账10元。
	 */
	public static void main(String[] args) {
		TransferService service = new TransferServiceImpl();

		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			executorService.execute(new TransferThread(service));
		}
		executorService.shutdown();
	}
}
