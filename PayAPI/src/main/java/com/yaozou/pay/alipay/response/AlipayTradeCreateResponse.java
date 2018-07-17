package com.yanwei.pay.alipay.response;

import com.yanwei.pay.alipay.internal.mapping.ApiField;

import com.yanwei.pay.alipay.AlipayResponse;

/**
 * ALIPAY API: alipay.trade.create response.
 * 
 * @author auto create
 * @since 1.0, 2018-03-23 19:14:48
 */
public class AlipayTradeCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 1891513357766215961L;

	/** 
	 * 商户订单号
	 */
	@ApiField("out_trade_no")
	private String outTradeNo;

	/** 
	 * 支付宝交易号
	 */
	@ApiField("trade_no")
	private String tradeNo;

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public String getOutTradeNo( ) {
		return this.outTradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public String getTradeNo( ) {
		return this.tradeNo;
	}

}
