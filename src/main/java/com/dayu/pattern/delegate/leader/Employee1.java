package com.dayu.pattern.delegate.leader;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-04 12:42
 */
public class Employee1 implements IEmployee {
    @Override
    public void doing(String cmd) {
        System.out.println("我是员工A，我干货了，"+cmd + "...");
    }
}