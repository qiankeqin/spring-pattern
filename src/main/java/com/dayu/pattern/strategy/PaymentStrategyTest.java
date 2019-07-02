package com.dayu.pattern.strategy;

import com.dayu.pattern.strategy.channel.AliPay;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-02 08:47
 */
public class PaymentStrategyTest {
    public static void main(String[] args) {
        //商品加入购物车

        //下单
        Order order = new Order("1","2019070200001",1000.00);

        //支付
        //选择微信支付、支付宝、银联卡支付等
        order.pay(PayChannel.WechatPay);
    }
}