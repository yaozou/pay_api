package com.yanwei.pay.weixin.model;/**
 * created by yaozou on 2018/5/21
 */

import com.yanwei.pay.weixin.WXPayConstants;

import java.util.Map;

/**
 * 统一下单结果
 * @author yaozou
 * @create 2018-05-21 13:52
 **/
public class UnifiedOrderResult extends ResultInfo {
    /**
     * 以下字段在return_code 和result_code都为SUCCESS的时候有返回
     */
    private String tradeType;
    //微信生成的预支付会话标识，用于后续接口调用中使用，该值有效期为2小时
    private String prepayId;
    //trade_type为NATIVE时有返回，用于生成二维码，展示给用户进行扫码支付
    private String codeUrl;

    public UnifiedOrderResult(Map<String,String> map){
        super(map);
        if (WXPayConstants.SUCCESS.equals(this.getResultCode())){
            this.tradeType = map.get("trade_type");
            this.prepayId = map.get("prepay_id");
            this.codeUrl = map.get("code_url");
        }
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }
}
