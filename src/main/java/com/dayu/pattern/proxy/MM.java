package com.dayu.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-06-27 08:42
 */
public class MM implements InvocationHandler {

    private Object target;


    public Object getInstance(Object target){
        this.target = target;
        Class<?> clazz = target.getClass();
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
        return o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("hello");
        method.invoke(this.target,args);
        System.out.println("world");
        return null;
    }
}