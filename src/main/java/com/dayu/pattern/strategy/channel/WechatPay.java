package com.dayu.pattern.strategy.channel;

import com.dayu.pattern.strategy.Payment;
import com.dayu.pattern.strategy.PaymentResp;

/**
 * @author qiankeqin
 * @Description: 微信支付
 * @date 2019-07-02 08:59
 */
public class WechatPay implements Payment {

    @Override
    public PaymentResp pay(String uid, double amount) {
        System.out.println("正在使用微信支付。。。");

        return new PaymentResp(0,"支付成功","wechatpay",amount);
    }
}