package com.dayu.pattern.strategy;

/**
 * @author qiankeqin
 * @Description: 支付返回
 * @date 2019-07-02 08:45
 */
public class PaymentResp {
    private int code;
    private Object data;
    private String msg;
    private String payChannel;

    public PaymentResp(int code, String msg, String payChannel, Object data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.payChannel = payChannel;
    }

    @Override
    public String toString() {
        return "PaymentResp{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                ", payChannel='" + payChannel + '\'' +
                '}';
    }
}