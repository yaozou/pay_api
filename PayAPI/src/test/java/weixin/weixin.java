package weixin;
/**
 * created by yaozou on 2018/5/21
 */

import com.yaozou.pay.weixin.WXPayService;
import com.yaozou.pay.weixin.model.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yaozou
 * @create 2018-05-21 16:05
 **/
public class weixin {
    Map<String, String> propertyMap = new HashMap<String, String>();
    WXPayService wxPayService;
    {
        init();
    }
    public void init(){
        propertyMap.put("certPath","");
        propertyMap.put("appID","");
        propertyMap.put("mchID","");
        /**
         * 交易秘钥：
         * 沙漏秘钥：
         */
        propertyMap.put("key","");
        try{
            wxPayService = WXPayService.getInstance(propertyMap);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testUnifiedOrderForJSAPI(){
        String body = "测试微信支付";
        String outTradeNo = String.valueOf(System.currentTimeMillis());
        String spbillCreateIp = "123.12.12.123";
        String notifyUrl = "http://test.letiantian.me/wxpay/notify";
        UnifiedOrder order = new UnifiedOrder( body,179,outTradeNo,
                spbillCreateIp,notifyUrl);
        order.setOpenid("ogzsMw6fgMu7PE2RXV0KlpzIVBmY");
        try {
            UnifiedOrderResult result = wxPayService.doUnifiedOrderForJSAPI(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDoOrderQuery(){
        String outTradeNo = "1526970570047";
        try {
            OrderQueryResult result =  wxPayService.doOrderQuery(outTradeNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDoOrderClose(){
        String outTradeNo = "1526970570047";
        try {
            wxPayService.doOrderClose(outTradeNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDoRefund(){
        String outTradeNo = "1526970570047";
        String outRefundNo = String.valueOf(System.currentTimeMillis());
        try {
            RefundOrder refundOrder = new RefundOrder(outTradeNo,outRefundNo, 179,
                     179,"");
            RefundResult result =  wxPayService.doRefund(refundOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDoRefundQuery(){
        String outRefundNo = "";
        try {
            Map<String, String> r = wxPayService.doRefundQuery(outRefundNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetsignkey(){
        try {
            Map map = wxPayService.getsignkey();
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
