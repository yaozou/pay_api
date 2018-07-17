package com.yanwei.pay.alipay.internal.parser.json;

import com.yanwei.pay.alipay.AlipayApiException;
import com.yanwei.pay.alipay.AlipayParser;
import com.yanwei.pay.alipay.AlipayRequest;
import com.yanwei.pay.alipay.AlipayResponse;
import com.yanwei.pay.alipay.SignItem;
import com.yanwei.pay.alipay.internal.mapping.Converter;

/**
 * 单个JSON对象解释器。
 * 
 * @author carver.gu
 * @since 1.0, Apr 11, 2010
 */
public class ObjectJsonParser<T extends AlipayResponse> implements AlipayParser<T> {

    private Class<T> clazz;

    public ObjectJsonParser(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T parse(String rsp) throws AlipayApiException {
        Converter converter = new JsonConverter();
        return converter.toResponse(rsp, clazz);
    }

    public Class<T> getResponseClass() {
        return clazz;
    }

    /** 
     * @see com.yanwei.pay.alipay.AlipayParser#getSignItem(com.yanwei.pay.alipay.AlipayRequest, String)
     */
    public SignItem getSignItem(AlipayRequest<?> request, String responseBody)
                                                                              throws AlipayApiException {

        Converter converter = new JsonConverter();

        return converter.getSignItem(request, responseBody);
    }

    /** 
     * @see com.yanwei.pay.alipay.AlipayParser#encryptSourceData(com.yanwei.pay.alipay.AlipayRequest, String, String, String, String, String)
     */
    public String encryptSourceData(AlipayRequest<?> request, String body, String format,
                                       String encryptType, String encryptKey, String charset)
                                                                                             throws AlipayApiException {

        Converter converter = new JsonConverter();

        return converter.encryptSourceData(request, body, format, encryptType, encryptKey,
            charset);
    }

}
