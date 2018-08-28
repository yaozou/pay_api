package com.yaozou.pay.alipay.response;

import java.util.Date;
import java.util.List;
import com.yaozou.pay.alipay.internal.mapping.ApiField;
import com.yaozou.pay.alipay.internal.mapping.ApiListField;
import com.yaozou.pay.alipay.domain.TradeFundBill;

import com.yaozou.pay.alipay.AlipayResponse;

/**
 * ALIPAY API: alipay.trade.refund response.
 * 
 * @author auto create
 * @since 1.0, 2018-03-22 17:12:24
 */
public class AlipayTradeRefundResponse extends AlipayResponse {

	private static final long serialVersionUID = 5814262949822835218L;

	/** 
	 * 用户的登录id
	 */
	@ApiField("buyer_logon_id")
	private String buyerLogonId;

	/** 
	 * 买家在支付宝的用户id
	 */
	@ApiField("buyer_user_id")
	private String buyerUserId;

	/** 
	 * 本次退款是否发生了资金变化
	 */
	@ApiField("fund_change")
	private String fundChange;

	/** 
	 * 退款支付时间
	 */
	@ApiField("gmt_refund_pay")
	private Date gmtRefundPay;

	/** 
	 * 买家支付宝用户号，该参数已废弃，请不要使用
	 */
	@ApiField("open_id")
	private String openId;

	/** 
	 * 商户订单号
	 */
	@ApiField("out_trade_no")
	private String outTradeNo;

	/** 
	 * 本次退款金额中买家退款金额
	 */
	@ApiField("present_refund_buyer_amount")
	private String presentRefundBuyerAmount;

	/** 
	 * 本次退款金额中平台优惠退款金额
	 */
	@ApiField("present_refund_discount_amount")
	private String presentRefundDiscountAmount;

	/** 
	 * 本次退款金额中商家优惠退款金额
	 */
	@ApiField("present_refund_mdiscount_amount")
	private String presentRefundMdiscountAmount;

	/** 
	 * 退款币种信息
	 */
	@ApiField("refund_currency")
	private String refundCurrency;

	/** 
	 * 退款使用的资金渠道
	 */
	@ApiListField("refund_detail_item_list")
	@ApiField("trade_fund_bill")
	private List<TradeFundBill> refundDetailItemList;

	/** 
	 * 退款总金额
	 */
	@ApiField("refund_fee")
	private String refundFee;

	/** 
	 * 本次商户实际退回金额
注：在签约收单产品时需勾选“返回资金明细”才会返回
	 */
	@ApiField("send_back_fee")
	private String sendBackFee;

	/** 
	 * 交易在支付时候的门店名称
	 */
	@ApiField("store_name")
	private String storeName;

	/** 
	 * 2013112011001004330000121536
	 */
	@ApiField("trade_no")
	private String tradeNo;

	public void setBuyerLogonId(String buyerLogonId) {
		this.buyerLogonId = buyerLogonId;
	}
	public String getBuyerLogonId( ) {
		return this.buyerLogonId;
	}

	public void setBuyerUserId(String buyerUserId) {
		this.buyerUserId = buyerUserId;
	}
	public String getBuyerUserId( ) {
		return this.buyerUserId;
	}

	public void setFundChange(String fundChange) {
		this.fundChange = fundChange;
	}
	public String getFundChange( ) {
		return this.fundChange;
	}

	public void setGmtRefundPay(Date gmtRefundPay) {
		this.gmtRefundPay = gmtRefundPay;
	}
	public Date getGmtRefundPay( ) {
		return this.gmtRefundPay;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getOpenId( ) {
		return this.openId;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public String getOutTradeNo( ) {
		return this.outTradeNo;
	}

	public void setPresentRefundBuyerAmount(String presentRefundBuyerAmount) {
		this.presentRefundBuyerAmount = presentRefundBuyerAmount;
	}
	public String getPresentRefundBuyerAmount( ) {
		return this.presentRefundBuyerAmount;
	}

	public void setPresentRefundDiscountAmount(String presentRefundDiscountAmount) {
		this.presentRefundDiscountAmount = presentRefundDiscountAmount;
	}
	public String getPresentRefundDiscountAmount( ) {
		return this.presentRefundDiscountAmount;
	}

	public void setPresentRefundMdiscountAmount(String presentRefundMdiscountAmount) {
		this.presentRefundMdiscountAmount = presentRefundMdiscountAmount;
	}
	public String getPresentRefundMdiscountAmount( ) {
		return this.presentRefundMdiscountAmount;
	}

	public void setRefundCurrency(String refundCurrency) {
		this.refundCurrency = refundCurrency;
	}
	public String getRefundCurrency( ) {
		return this.refundCurrency;
	}

	public void setRefundDetailItemList(List<TradeFundBill> refundDetailItemList) {
		this.refundDetailItemList = refundDetailItemList;
	}
	public List<TradeFundBill> getRefundDetailItemList( ) {
		return this.refundDetailItemList;
	}

	public void setRefundFee(String refundFee) {
		this.refundFee = refundFee;
	}
	public String getRefundFee( ) {
		return this.refundFee;
	}

	public void setSendBackFee(String sendBackFee) {
		this.sendBackFee = sendBackFee;
	}
	public String getSendBackFee( ) {
		return this.sendBackFee;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreName( ) {
		return this.storeName;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public String getTradeNo( ) {
		return this.tradeNo;
	}

}
