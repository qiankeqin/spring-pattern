package com.dayu.pattern.proxy;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-06-26 19:37
 */
public class Son {

    private String name;

    public Son(String name) {
        this.name = name;
    }

    public void find(){
        System.out.println("son find");
    }
}