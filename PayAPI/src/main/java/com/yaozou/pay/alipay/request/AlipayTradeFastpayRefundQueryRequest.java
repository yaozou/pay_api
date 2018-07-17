package com.yanwei.pay.alipay.request;

import com.yanwei.pay.alipay.domain.AlipayTradeFastpayRefundQueryModel;
import java.util.Map;

import com.yanwei.pay.alipay.AlipayRequest;
import com.yanwei.pay.alipay.internal.util.AlipayHashMap;
import com.yanwei.pay.alipay.response.AlipayTradeFastpayRefundQueryResponse;
import com.yanwei.pay.alipay.AlipayObject;

/**
 * ALIPAY API: alipay.trade.fastpay.refund.query request
 * 
 * @author auto create
 * @since 1.0, 2018-04-01 11:45:00
 */
public class AlipayTradeFastpayRefundQueryRequest implements AlipayRequest<AlipayTradeFastpayRefundQueryResponse> {

	private AlipayHashMap udfParams; // add user-defined text parameters
	private String apiVersion="1.0";

	/** 
	* 商户可使用该接口查询自已通过alipay.trade.refund提交的退款请求是否执行成功。
	 */
	private String bizContent;

	public void setBizContent(String bizContent) {
		this.bizContent = bizContent;
	}
	public String getBizContent() {
		return this.bizContent;
	}
	private String terminalType;
	private String terminalInfo;	
	private String prodCode;
	private String notifyUrl;
	private String returnUrl;
	private boolean needEncrypt=false;
	private AlipayObject bizModel=null;

	public String getNotifyUrl() {
		return this.notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getReturnUrl() {
		return this.returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getApiVersion() {
		return this.apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public void setTerminalType(String terminalType){
		this.terminalType=terminalType;
	}

    public String getTerminalType(){
    	return this.terminalType;
    }

    public void setTerminalInfo(String terminalInfo){
    	this.terminalInfo=terminalInfo;
    }

    public String getTerminalInfo(){
    	return this.terminalInfo;
    }	

	public void setProdCode(String prodCode) {
		this.prodCode=prodCode;
	}

	public String getProdCode() {
		return this.prodCode; 
	}

	public String getApiMethodName() {
		return "alipay.trade.fastpay.refund.query";
	}

	public Map<String, String> getTextParams() {		
		AlipayHashMap txtParams = new AlipayHashMap();
		txtParams.put("biz_content", this.bizContent);
		if(udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public void putOtherTextParam(String key, String value) {
		if(this.udfParams == null) {
			this.udfParams = new AlipayHashMap();
		}
		this.udfParams.put(key, value);
	}

	public Class<AlipayTradeFastpayRefundQueryResponse> getResponseClass() {
		return AlipayTradeFastpayRefundQueryResponse.class;
	}
	

    public boolean isNeedEncrypt() {
    
      return this.needEncrypt;
    }


    public void setNeedEncrypt(boolean needEncrypt) {
    
         this.needEncrypt=needEncrypt;
    }
    
    public AlipayObject getBizModel() {
    
      return this.bizModel;
    }


    public void setBizModel(AlipayObject bizModel) {
    
         this.bizModel=bizModel;
    }
	
	
}
