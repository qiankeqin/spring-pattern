package com.dayu.pattern.factory;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-06-24 13:27
 */
public class SuperMilkFactory extends AbstractFactory {
    @Override
    public Milk getMengNiu() {
        return new YiliMilkFactory().makeMilk();

    }

    @Override
    public Milk getYili() {
        return new YiliMilkFactory().makeMilk();
    }
}