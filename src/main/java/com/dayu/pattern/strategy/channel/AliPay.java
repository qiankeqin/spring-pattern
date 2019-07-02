package com.dayu.pattern.strategy.channel;

import com.dayu.pattern.strategy.Payment;
import com.dayu.pattern.strategy.PaymentResp;

/**
 * @author qiankeqin
 * @Description: 支付宝支付
 * @date 2019-07-02 08:59
 */
public class AliPay implements Payment {

    @Override
    public PaymentResp pay(String uid, double amount) {
        System.out.println("正在使用支付宝支付。。。");

        return new PaymentResp(0,"支付成功","alipay",amount);
    }
}