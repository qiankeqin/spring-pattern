package com.dayu.pattern.strategy;

import com.dayu.pattern.strategy.channel.AliPay;
import com.dayu.pattern.strategy.channel.WechatPay;

/**
 * @author qiankeqin
 * @Description: 支付通道支付台
 * @date 2019-07-02 09:11
 */
public enum PayChannel {
    AliPay(new AliPay()),
    WechatPay(new WechatPay()),
    None(new WechatPay());

    private Payment payment;

    PayChannel(Payment payment) {
        this.payment = payment;
    }

    public Payment get(){
        return this.payment;
    }
}