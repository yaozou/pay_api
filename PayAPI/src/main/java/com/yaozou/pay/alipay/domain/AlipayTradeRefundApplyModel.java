package com.yaozou.pay.alipay.domain;

import com.yaozou.pay.alipay.AlipayObject;
import com.yaozou.pay.alipay.internal.mapping.ApiField;

/**
 * 异步退款受理接口
 *
 * @author auto create
 * @since 1.0, 2018-03-16 18:35:26
 */
public class AlipayTradeRefundApplyModel extends AlipayObject {

	private static final long serialVersionUID = 7114859831469397774L;

	/**
	 * 商户传入业务信息，具体值要和支付宝约定，格式为json格式。
医保退款场景下，DESIGNATED_REFUND_ASSET为INNER_ASSET表示只退自费部分，DESIGNATED_REFUND_ASSET为OUTSIDE_ASSET表示只退医保部分，医保部分不支持部分退。退医保资金必需传cancel_bill_no和cancel_serial_no。
	 */
	@ApiField("extend_params")
	private String extendParams;

	/**
	 * 商户的操作员编号
	 */
	@ApiField("operator_id")
	private String operatorId;

	/**
	 * 标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传。
	 */
	@ApiField("out_request_no")
	private String outRequestNo;

	/**
	 * 订单支付时传入的商户订单号,不能和 trade_no同时为空
	 */
	@ApiField("out_trade_no")
	private String outTradeNo;

	/**
	 * 需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数
	 */
	@ApiField("refund_amount")
	private String refundAmount;

	/**
	 * 退款的原因说明
	 */
	@ApiField("refund_reason")
	private String refundReason;

	/**
	 * 商户的门店编号
	 */
	@ApiField("store_id")
	private String storeId;

	/**
	 * 商户的终端编号
	 */
	@ApiField("terminal_id")
	private String terminalId;

	/**
	 * 支付宝交易号，和商户订单号不能同时为空
	 */
	@ApiField("trade_no")
	private String tradeNo;

	public String getExtendParams() {
		return this.extendParams;
	}
	public void setExtendParams(String extendParams) {
		this.extendParams = extendParams;
	}

	public String getOperatorId() {
		return this.operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getOutRequestNo() {
		return this.outRequestNo;
	}
	public void setOutRequestNo(String outRequestNo) {
		this.outRequestNo = outRequestNo;
	}

	public String getOutTradeNo() {
		return this.outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getRefundAmount() {
		return this.refundAmount;
	}
	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getRefundReason() {
		return this.refundReason;
	}
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public String getStoreId() {
		return this.storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getTerminalId() {
		return this.terminalId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

}
