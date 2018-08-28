package com.yaozou.pay.alipay.config;
/**
 * created by yaozou on 2018/6/4
 */

import com.yaozou.pay.alipay.AlipayConstants;
import com.yaozou.pay.alipay.AlipayObject;

import java.util.Map;

/**
 * 支付宝配置
 * @author yaozou
 * @create 2018-06-04 11:21
 **/
public class AlipayConfig extends AlipayObject {
    private static AlipayConfig INSTANCE;
    private String appId;
    private String privateKey ;
    private String alipayPublicKey;

    private AlipayConfig(Map<String, String> propertyMap){
        this.appId = propertyMap.get("appId");
        this.privateKey = propertyMap.get("privateKey");
        this.alipayPublicKey = propertyMap.get("alipayPublicKey");
    }

    public static AlipayConfig getInstance(Map<String, String> propertyMap) throws Exception{
        if (INSTANCE == null) {
            synchronized (AlipayConfig.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AlipayConfig(propertyMap);
                }
            }
        }
        return INSTANCE;
    }

    public String getAppId() {
        return appId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public String format(){
        return AlipayConstants.FORMAT_JSON;
    }
    public String charset(){
        return AlipayConstants.CHARSET_UTF8;
    }
    public String signType(){return AlipayConstants.SIGN_TYPE_RSA2;}
}
