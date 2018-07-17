package com.yanwei.pay.alipay.response;

import com.yanwei.pay.alipay.internal.mapping.ApiField;

import com.yanwei.pay.alipay.AlipayResponse;

/**
 * ALIPAY API: alipay.trade.close response.
 * 
 * @author auto create
 * @since 1.0, 2017-12-14 16:27:58
 */
public class AlipayTradeCloseResponse extends AlipayResponse {

	private static final long serialVersionUID = 1143253372843898556L;

	/** 
	 * 创建交易传入的商户订单号
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
