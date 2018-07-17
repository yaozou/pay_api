package com.yanwei.pay.weixin.model;/**
 * created by yaozou on 2018/5/21
 */

import com.yanwei.pay.weixin.WXPayConstants;

import java.util.Map;

/**
 * 退款结果
 * @author yaozou
 * @create 2018-05-21 15:03
 **/
public class RefundResult extends ResultInfo {
    private String transactionId;
    private String outTradeNo;

    private String outRefundNo;
    private String refundId;

    private Integer refundFee;
    private Integer totalFee;

    public RefundResult(Map<String,String> map){
        super(map);
        if (WXPayConstants.SUCCESS.equals(this.getResultCode())){
            this.transactionId = map.get("transaction_id");
            this.outTradeNo = map.get("out_trade_no");

            this.outRefundNo = map.get("out_refund_no");
            this.refundId = map.get("refund_id");

            this.refundFee = Integer.valueOf(map.get("refund_fee"));
            this.totalFee = Integer.valueOf(map.get("total_fee"));
        }
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public Integer getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Integer refundFee) {
        this.refundFee = refundFee;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }
}
