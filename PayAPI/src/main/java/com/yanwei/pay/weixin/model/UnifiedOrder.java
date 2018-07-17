package com.yanwei.pay.weixin.model;/**
 * created by yaozou on 2018/5/21
 */

/**
 * 统一下单
 * @author yaozou
 * @create 2018-05-21 10:53
 **/
public class UnifiedOrder {
    private String body;
    private Integer totalFee;
    private String outTradeNo;
    private String spbillCreateIp;
    private String notifyUrl;

    //trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义。
    private String productId;

    //trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。
    private String openid;

    public UnifiedOrder(String body,Integer totalFee,String outTradeNo,
                        String spbillCreateIp,String notifyUrl){
        this.body = body;
        this.totalFee = totalFee;
        this.outTradeNo = outTradeNo;
        this.spbillCreateIp = spbillCreateIp;
        this.notifyUrl = notifyUrl;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getOpenid() {
        return openid;
    }
}
