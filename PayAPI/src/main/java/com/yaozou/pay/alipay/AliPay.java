package com.yanwei.pay.alipay;/**
 * created by yaozou on 2018/6/4
 */

import com.alibaba.fastjson.JSON;
import com.yanwei.pay.alipay.config.AlipayConfig;
import com.yanwei.pay.alipay.internal.parser.json.JsonConverter;
import com.yanwei.pay.alipay.request.AlipayTradeAppPayRequest;
import com.yanwei.pay.alipay.request.AlipayTradeFastpayRefundQueryRequest;
import com.yanwei.pay.alipay.request.AlipayTradeQueryRequest;
import com.yanwei.pay.alipay.request.AlipayTradeRefundRequest;
import com.yanwei.pay.alipay.response.AlipayTradeAppPayResponse;
import com.yanwei.pay.alipay.response.AlipayTradeFastpayRefundQueryResponse;
import com.yanwei.pay.alipay.response.AlipayTradeQueryResponse;
import com.yanwei.pay.alipay.response.AlipayTradeRefundResponse;

import java.util.Map;

/**
 * 微信支付
 * @author yaozou
 * @create 2018-06-04 11:11
 **/
public class AliPay {
    private AlipayConfig config;
    public AliPay(final AlipayConfig config) throws Exception {
        this.config = config;
    }

    /**
     * app支付接口2.0
     */
    public AlipayTradeAppPayResponse tradeAppPay(Map<String, String> reqData) throws AlipayApiException{
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
                config.getAppId(),config.getPrivateKey(),config.format(),config.charset(),
                config.getAlipayPublicKey(),config.signType());
        String notifyUrl = reqData.get("notifyUrl");
        reqData.remove("notifyUrl");

        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        request.setNotifyUrl(notifyUrl);

        request.setBizContent(JSON.toJSON(reqData).toString());
        AlipayTradeAppPayResponse response = alipayClient.pageExecute(request);
        return response;
    }

    /**
     * 统一收单交易退款接口
     * @param reqData
     * @return
     * @throws AlipayApiException
     */
    public AlipayTradeRefundResponse tradeRefund(Map<String, String> reqData) throws AlipayApiException{
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
                config.getAppId(),config.getPrivateKey(),config.format(),config.charset(),
                config.getAlipayPublicKey(),config.signType());

        String notifyUrl = reqData.get("notifyUrl");
        reqData.remove("notifyUrl");

        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent(JSON.toJSON(reqData).toString());
        AlipayTradeRefundResponse response = alipayClient.execute(request);
        return response;
    }

    /**
     * 统一收单交易查询
     * @param reqData
     * @return
     * @throws Exception
     */
    public AlipayTradeQueryResponse tradeQuery(Map<String, String> reqData) throws Exception{
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
                config.getAppId(),config.getPrivateKey(),config.format(),config.charset(),
                config.getAlipayPublicKey(),config.signType());
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent(JSON.toJSON(reqData).toString());
        AlipayTradeQueryResponse response = alipayClient.execute(request);
        return response;
    }


    /**
     * 统一收单交易退款查询
     * @param reqData
     * @return
     * @throws Exception
     */
    public AlipayTradeFastpayRefundQueryResponse tradeFastpayRefundQuery(Map<String, String> reqData) throws Exception{
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
                config.getAppId(),config.getPrivateKey(),config.format(),config.charset(),
                config.getAlipayPublicKey(),config.signType());
        AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
        request.setBizContent(JSON.toJSON(reqData).toString());
        AlipayTradeFastpayRefundQueryResponse response = alipayClient.execute(request);
        return response;
    }

}
