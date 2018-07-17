package com.yanwei.pay.alipay.domain;

import java.util.List;

import com.yanwei.pay.alipay.AlipayObject;
import com.yanwei.pay.alipay.internal.mapping.ApiField;
import com.yanwei.pay.alipay.internal.mapping.ApiListField;

/**
 * 描述结算信息，json格式。
 *
 * @author auto create
 * @since 1.0, 2018-04-04 18:19:51
 */
public class SettleInfo extends AlipayObject {

	private static final long serialVersionUID = 2531273325899956995L;

	/**
	 * 结算详细信息，json数组，目前只支持一条。
	 */
	@ApiListField("settle_detail_infos")
	@ApiField("settle_detail_info")
	private List<SettleDetailInfo> settleDetailInfos;

	public List<SettleDetailInfo> getSettleDetailInfos() {
		return this.settleDetailInfos;
	}
	public void setSettleDetailInfos(List<SettleDetailInfo> settleDetailInfos) {
		this.settleDetailInfos = settleDetailInfos;
	}

}
