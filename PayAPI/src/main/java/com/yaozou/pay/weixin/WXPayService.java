package com.yanwei.pay.weixin;/**
 * created by yaozou on 2018/5/21
 */

import com.yanwei.pay.weixin.impl.WXPayConfigImpl;
import com.yanwei.pay.weixin.model.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信支付
 * @author yaozou
 * @create 2018-05-21 11:16
 **/
public class WXPayService {
    private static WXPayService INSTANCE = null;
    private static WXPay wxpay;
    public static WXPayService getInstance(Map<String, String> propertyMap) throws Exception {
        if (INSTANCE == null) {
            INSTANCE = new WXPayService();
            WXPayConfigImpl config = WXPayConfigImpl.getInstance(propertyMap);
            wxpay = new WXPay(config);
        }
        return INSTANCE;
    }

    /**
     * 公众号支付或小程序支付
     * @param unifiedOrder
     */
    public UnifiedOrderResult doUnifiedOrderForJSAPI(UnifiedOrder unifiedOrder) throws Exception{
       return  new UnifiedOrderResult(doUnifiedOrder(unifiedOrder, WXPayConstants.TradeType.JSAPI));
    }

    /**
     * APP支付
     * @param unifiedOrder
     * @return
     * @throws Exception
     */
    public UnifiedOrderResult doUnifiedOrderForAPP(UnifiedOrder unifiedOrder) throws Exception{
        return  new UnifiedOrderResult(doUnifiedOrder(unifiedOrder, WXPayConstants.TradeType.APP));
    }

    /**
     * 统一下单
     */
    public Map<String, String> doUnifiedOrder(UnifiedOrder unifiedOrder , WXPayConstants.TradeType tradeType) throws Exception {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("body", unifiedOrder.getBody());
        data.put("out_trade_no", unifiedOrder.getOutTradeNo());
        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", unifiedOrder.getTotalFee().toString());
        data.put("spbill_create_ip", unifiedOrder.getSpbillCreateIp());
        data.put("notify_url", unifiedOrder.getNotifyUrl());

        data.put("trade_type", tradeType.getCode());

        if ("NATIVE".equals(tradeType.getCode())) data.put("product_id", unifiedOrder.getProductId());
        if ("JSAPI".equals(tradeType.getCode())) data.put("openid", unifiedOrder.getOpenid());

        WXPayUtil.getLogger().info("微信统一下单参数："+data);
        Map<String, String> r = wxpay.unifiedOrder(data);
        WXPayUtil.getLogger().info("微信统一下单结果："+r);
        return  r;
    }


    /**
     * 关闭订单
     * @param outTradeNo
     * @return
     * @throws Exception
     */
    public Map<String, String> doOrderClose(String outTradeNo) throws Exception {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", outTradeNo);
        Map<String, String> r = wxpay.closeOrder(data);
        WXPayUtil.getLogger().info("微信订单关闭结果："+r);
        return r;
    }

    /**
     * 订单查询
     * @param outTradeNo
     * @return
     * @throws Exception
     */
    public OrderQueryResult doOrderQuery(String outTradeNo) throws  Exception {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", outTradeNo);
        Map<String, String> r = wxpay.orderQuery(data);

        WXPayUtil.getLogger().info("微信订单结果："+r);
        return new OrderQueryResult(r);
    }

    /**
     * 退款
     */
    public RefundResult doRefund(RefundOrder refundOrder) throws Exception {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", refundOrder.getOutTradeNo());
        data.put("out_refund_no", refundOrder.getOutRefundNo());
        data.put("total_fee", refundOrder.getTotalFee().toString());
        data.put("refund_fee", refundOrder.getRefundFee().toString());
        data.put("refund_fee_type", "CNY");

        WXPayUtil.getLogger().info("微信退款参数："+data);
        Map<String, String> r = wxpay.refund(data);
        WXPayUtil.getLogger().info("微信退款结果："+r);
        return new RefundResult(r);
    }

    /**
     * 查询退款
     */
    public Map<String, String> doRefundQuery(String outRefundNo) throws Exception {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("out_refund_no", outRefundNo);
        Map<String, String> r = wxpay.refundQuery(data);
        WXPayUtil.getLogger().info("微信退款查询结果："+r);
        return r;
    }

    public Map<String, String> doOrderReverse(String outTradeNo) throws Exception {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", outTradeNo);
        Map<String, String> r = wxpay.reverse(data);
        return r;
    }

    /**
     * 长链接转短链接
     */
    public Map<String, String> doShortUrl(String longUrl) throws Exception {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("long_url", longUrl);
        Map<String, String> r = wxpay.shortUrl(data);
        return r;
    }

    /**
     * 对账单下载
     */
    public Map<String, String> doDownloadBill(String billDate , String billType) throws Exception {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("bill_date", billDate);
        data.put("bill_type", billType);
        Map<String, String> r = wxpay.downloadBill(data);
        return r;
    }

    /**
     * 获取验签秘钥
     */
    public Map<String, String> getsignkey() throws Exception {
        return wxpay.getsignkey();
    }
}
