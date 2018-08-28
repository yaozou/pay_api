package com.yaozou.pay.weixin.model;/**
 * created by yaozou on 2018/5/21
 */

/**
 * 退款订单
 * @author yaozou
 * @create 2018-05-21 11:36
 **/
public class RefundOrder {
    private String outTradeNo;
    private String outRefundNo;
    private Integer totalFee;
    private Integer refundFee;

    private String notifyUrl;

    public RefundOrder(String outTradeNo,String outRefundNo,Integer totalFee,
                       Integer refundFee,String notifyUrl){
        this.outTradeNo = outTradeNo;
        this.outRefundNo = outRefundNo;
        this.totalFee = totalFee;
        this.refundFee =  refundFee;
        this.notifyUrl = notifyUrl;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setRefundFee(Integer refundFee) {
        this.refundFee = refundFee;
    }

    public Integer getRefundFee() {
        return refundFee;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }
}
