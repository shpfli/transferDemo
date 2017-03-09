/**
 * 
 */
package com.test.transfer.bean;

/**
 * @author Hubery
 *
 */
public class TransferResponse {
	/**
	 * 响应代码
	 */
	private String responseCode;

	/**
	 * 响应消息
	 */
	private String responseMsg;

	public TransferResponse() {
		super();
	}

	public TransferResponse(String responseCode, String responseMsg) {
		super();
		this.responseCode = responseCode;
		this.responseMsg = responseMsg;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	@Override
	public String toString() {
		return "TransferResponse [responseCode=" + responseCode + ", responseMsg=" + responseMsg + "]";
	}

}
