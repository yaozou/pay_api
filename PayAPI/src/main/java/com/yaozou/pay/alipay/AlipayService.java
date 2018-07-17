package com.yanwei.pay.alipay;
/**
 * created by yaozou on 2018/6/4
 */

import com.yanwei.pay.alipay.config.AlipayConfig;
import com.yanwei.pay.alipay.domain.AlipayTradeAppPayModel;
import com.yanwei.pay.alipay.domain.AlipayTradeQueryModel;
import com.yanwei.pay.alipay.domain.AlipayTradeRefundModel;
import com.yanwei.pay.alipay.internal.util.AlipayHashMap;
import com.yanwei.pay.alipay.request.AlipayTradePayRequest;
import com.yanwei.pay.alipay.response.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付宝支付
 * @author yaozou
 * @create 2018-06-04 10:27
 **/
public class AlipayService {
    private static AlipayService INSTANCE = null;
    private static AliPay aliPay;
    public static AlipayService getInstance(Map<String, String> propertyMap) throws Exception {
        if (INSTANCE == null) {
            INSTANCE = new AlipayService();

            AlipayConfig config = AlipayConfig.getInstance(propertyMap);
            aliPay = new AliPay(config);
        }
        return INSTANCE;
    }

    public AlipayTradeAppPayResponse doTradeAppPay(AlipayTradeAppPayModel model, String notifyUrl) throws Exception{
        AlipayHashMap data = model.getTextParams();
        data.put("notifyUrl",notifyUrl);
        return aliPay.tradeAppPay(data);
    }

    public AlipayTradeRefundResponse doTradeRefund(AlipayTradeRefundModel model,String notifyUrl) throws  Exception{
        AlipayHashMap data = model.getTextParams();
        data.put("notifyUrl",notifyUrl);
        return aliPay.tradeRefund(data);
    }

    public AlipayTradeQueryResponse doTradeQuery(AlipayTradeQueryModel model) throws Exception{
        AlipayHashMap data = model.getTextParams();
        return aliPay.tradeQuery(data);
    }

    public AlipayTradeFastpayRefundQueryResponse doTradeFastpayRefundQuery(AlipayTradeQueryModel model) throws Exception{
        AlipayHashMap data = model.getTextParams();
        return aliPay.tradeFastpayRefundQuery(data);
    }

}
