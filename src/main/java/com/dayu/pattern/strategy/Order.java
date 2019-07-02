package com.dayu.pattern.strategy;

/**
 * @author qiankeqin
 * @Description: 订单
 * @date 2019-07-02 08:30
 */
public class Order {
    private String uid;
    private String orderId;
    private Double amount;

    public Order(String uid, String orderId, Double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public PaymentResp pay(PayChannel payChannel){
        return payChannel.get().pay(uid,amount);
    }
}