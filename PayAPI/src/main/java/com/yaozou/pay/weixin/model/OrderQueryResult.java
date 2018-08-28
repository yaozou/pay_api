package com.yaozou.pay.weixin.model;/**
 * created by yaozou on 2018/5/21
 */

import com.yaozou.pay.weixin.WXPayConstants;

import java.util.Map;

/**
 * 订单查询结果
 * @author yaozou
 * @create 2018-05-21 14:24
 **/
public class OrderQueryResult extends ResultInfo {
    private String openid;
    //用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
    private String isSubscribe;
    private String tradeType;

    /**
     * SUCCESS—支付成功
     REFUND—转入退款
     NOTPAY—未支付
     CLOSED—已关闭
     REVOKED—已撤销（刷卡支付）
     USERPAYING--用户支付中
     PAYERROR--支付失败(其他原因，如银行返回失败)
     */
    private String tradeState;
    //付款银行
    private String bankType;
    //订单总金额，单位为分
    private Integer totalFee;

    private String transactionId;
    private String outTradeNo;

    //支付完成时间 yyyyMMddHHmmss
    private String timeEnd;

    public OrderQueryResult(Map<String,String> map){
        super(map);
        if (WXPayConstants.SUCCESS.equals(this.getResultCode())){
            this.openid = map.get("openid");
            this.isSubscribe = map.get("is_subscribe");
            this.tradeType = map.get("trade_type");

            this.tradeState = map.get("trade_state");
            if ("SUCCESS".equals(this.getTradeState()) || "REFUND".equals(this.getTradeState())){
                this.bankType = map.get("bank_type");
                this.totalFee = Integer.valueOf(map.get("total_fee"));

                this.transactionId = map.get("transaction_id");
                this.outTradeNo = map.get("out_trade_no");

                this.timeEnd = map.get("time_end");
            }
        }
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getIsSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(String isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
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

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }
}
