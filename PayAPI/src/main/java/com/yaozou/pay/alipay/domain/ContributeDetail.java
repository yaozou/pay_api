package com.yaozou.pay.alipay.domain;

import com.yaozou.pay.alipay.AlipayObject;
import com.yaozou.pay.alipay.internal.mapping.ApiField;

/**
 * 出资方明细
 *
 * @author auto create
 * @since 1.0, 2017-10-31 18:26:14
 */
public class ContributeDetail extends AlipayObject {

	private static final long serialVersionUID = 2369146895935562369L;

	/**
	 * 出资方金额
	 */
	@ApiField("contribute_amount")
	private String contributeAmount;

	/**
	 * 出资方类型，如品牌商出资、支付宝平台出资等
	 */
	@ApiField("contribute_type")
	private String contributeType;

	public String getContributeAmount() {
		return this.contributeAmount;
	}
	public void setContributeAmount(String contributeAmount) {
		this.contributeAmount = contributeAmount;
	}

	public String getContributeType() {
		return this.contributeType;
	}
	public void setContributeType(String contributeType) {
		this.contributeType = contributeType;
	}

}
