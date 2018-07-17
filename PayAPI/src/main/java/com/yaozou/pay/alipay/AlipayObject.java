package com.yanwei.pay.alipay;

import com.alibaba.fastjson.JSON;
import com.yanwei.pay.alipay.domain.AlipayTradeAppPayModel;
import com.yanwei.pay.alipay.domain.ExtUserInfo;
import com.yanwei.pay.alipay.internal.mapping.ApiField;
import com.yanwei.pay.alipay.internal.util.AlipayHashMap;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Base Data Structure.
 * 
 * @author carver.gu
 * @since 1.0, Apr 11, 2010
 */
public abstract class AlipayObject implements Serializable {

	private static final long serialVersionUID = 1L;

	public AlipayHashMap getTextParams() throws Exception{
		AlipayHashMap map = new AlipayHashMap();
		Field[] fields = getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(ApiField.class)){
				ApiField apiField = field.getAnnotation(ApiField.class);
				String key = apiField.value();

				String methodName = "get"+upperFirstCase(field.getName());
				Method method = getClass().getDeclaredMethod(methodName);
				Object obj = method.invoke(this);

				String value = new String();
				if (obj != null ){
					if (obj instanceof String || obj instanceof Number) {
						value = obj.toString();
						map.put(key,value);
					}else {
						Method methodParam = obj.getClass().getMethod("getTextParams");
						map.put(key,JSON.toJSONString(methodParam.invoke(obj)));
					}
				}
			}

		}
		return map;
	}

	private String upperFirstCase(String name){
		char[] chars = name.toCharArray();
		if(chars[0] >= 97 && chars[0] <= 122) {
			chars[0] -= 32;
		}
		return new String(chars);
	}

	public static void main(String[] args){
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody("aaaaa");

		ExtUserInfo extUserInfo = new ExtUserInfo();
		extUserInfo.setName("qqqqqq");
		model.setExtUserInfo(extUserInfo);

		model.setOutTradeNo("111111");

		try {
			System.out.println(model.getTextParams());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
