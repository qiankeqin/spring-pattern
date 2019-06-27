package com.dayu.pattern.proxy;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-06-26 20:04
 */
public class XPerson {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void find(){
        System.out.println("xperson find");
    }
}