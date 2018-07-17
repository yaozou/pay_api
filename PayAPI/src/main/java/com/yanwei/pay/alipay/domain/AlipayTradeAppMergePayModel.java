package com.yanwei.pay.alipay.domain;

import com.yanwei.pay.alipay.AlipayObject;
import com.yanwei.pay.alipay.internal.mapping.ApiField;

/**
 * app合并支付接口
 *
 * @author auto create
 * @since 1.0, 2017-03-14 19:15:40
 */
public class AlipayTradeAppMergePayModel extends AlipayObject {

	private static final long serialVersionUID = 3136214834298878113L;

	/**
	 * 如果预创建成功，支付宝返回该预下单号，后续商户使用该预下单号请求支付宝支付接口
	 */
	@ApiField("pre_order_no")
	private String preOrderNo;

	public String getPreOrderNo() {
		return this.preOrderNo;
	}
	public void setPreOrderNo(String preOrderNo) {
		this.preOrderNo = preOrderNo;
	}

}
