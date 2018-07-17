package com.yanwei.pay.weixin.model;/**
 * created by yaozou on 2018/5/21
 */

import com.yanwei.pay.weixin.WXPayConstants;

import java.util.Map;

/**
 * 结果返回公共部分
 * @author yaozou
 * @create 2018-05-21 14:25
 **/
public class ResultInfo {
    //通信标识 SUCCESS/FAIL
    private String returnCode;
    //签名失败
    private String returnMsg;

    /**
     * 以下字段在return_code为SUCCESS的时候有返回
     */
    //业务结果  SUCCESS/FAIL
    private String resultCode;
    //错误代码
    private String errCode;
    //错误信息描述
    private String errCodeDes;
    //微信返回的随机字符串
    private String nonceStr;
    //微信返回的签名值
    private String sign;

    public ResultInfo(Map<String,String> map){
        this.setReturnCode(map.get("return_code"));
        this.setReturnMsg(map.get("return_msg"));

        if (WXPayConstants.SUCCESS.equals(this.getReturnCode())){
            this.resultCode = map.get("result_code");
            this.errCode = map.get("err_code");
            this.errCodeDes = map.get("err_code_des");

            this.nonceStr = map.get("nonce_str");
            this.sign = map.get("sign");
        }
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
