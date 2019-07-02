package com.dayu.pattern.strategy;

/**
 * @author qiankeqin
 * @Description: 支付接口
 * @date 2019-07-02 08:44
 */
public interface Payment {
    PaymentResp pay(String uid,double amount);
}