package com.dayu.pattern.factory;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-06-24 13:19
 */
public class YiliMilkFactory implements MilkFactory {
    @Override
    public Milk makeMilk() {
        return new YiliMilk();
    }
}