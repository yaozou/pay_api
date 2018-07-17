package com.yanwei.pay.alipay.internal.util.json;

public class StdoutStreamErrorListener extends BufferErrorListener {
    
    public void end() {
        System.out.print(buffer.toString());
    }
}
