package com.yanwei.pay.weixin.impl;

import com.yanwei.pay.weixin.IWXPayDomain;
import com.yanwei.pay.weixin.WXPayConfig;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

public class WXPayConfigImpl extends WXPayConfig {

    private byte[] certData;
    private static WXPayConfigImpl INSTANCE;
    private String certPath; //证书地址
    private String appID;
    private String mchID;
    private String key;


    private WXPayConfigImpl(Map<String, String> propertyMap) throws Exception{
        this.certPath = propertyMap.get("certPath");
        if (certPath != null && !"".equals(certPath)){
            File file = new File(this.certPath);
            InputStream certStream = new FileInputStream(file);
            this.certData = new byte[(int) file.length()];
            certStream.read(this.certData);
            certStream.close();
        }

        this.appID = propertyMap.get("appID");
        this.mchID = propertyMap.get("mchID");
        this.key   = propertyMap.get("key");
    }

    public static WXPayConfigImpl getInstance(Map<String, String> propertyMap) throws Exception{
        if (INSTANCE == null) {
            synchronized (WXPayConfigImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WXPayConfigImpl(propertyMap);
                }
            }
        }
        return INSTANCE;
    }

    public String getAppID() {
        return this.appID;
    }

    public String getMchID() {
        return this.mchID;
    }

    public String getKey() {
        return this.key;
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis;
        certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }


    public int getHttpConnectTimeoutMs() {
        return 2000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    public IWXPayDomain getWXPayDomain() {
        return WXPayDomainSimpleImpl.instance();
    }

    public String getPrimaryDomain() {
        return "api.mch.weixin.qq.com";
    }

    public String getAlternateDomain() {
        return "api2.mch.weixin.qq.com";
    }

    @Override
    public int getReportWorkerNum() {
        return 1;
    }

    @Override
    public int getReportBatchSize() {
        return 2;
    }
}
