package com.dayu.pattern.proxy.custom;

import com.dayu.pattern.proxy.Person;

import java.lang.reflect.Method;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-06-28 13:19
 */
public class CustomProxy implements GPInvocationHandler{

    private Person target;

    public Object getInstance(Person target){
        this.target = target;
        Class<?> clazz = target.getClass();
        return  GPProxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("123");
        method.invoke(target,args);
        System.out.println("456");
        return null;
    }
}