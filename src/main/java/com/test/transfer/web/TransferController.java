/**
 * 
 */
package com.test.transfer.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.transfer.bean.TransferRequest;
import com.test.transfer.bean.TransferResponse;
import com.test.transfer.service.TransferService;

/**
 * @author Hubery
 *
 */
@RestController
public class TransferController {
	private static final Log log = LogFactory.getLog(TransferController.class);
	@Autowired
	private TransferService transferService;

	@RequestMapping("/transfer")
	public TransferResponse transfer(TransferRequest request) {
		log.info(request);
		TransferResponse rsp = transferService.transfer(request);
		log.info(rsp);
		return rsp;
	}
}
