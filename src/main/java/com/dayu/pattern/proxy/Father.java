package com.dayu.pattern.proxy;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-06-26 19:38
 */
public class Father {

    private Son son;

    public Father(Son son) {
        this.son = son;
    }

    public void find(){
        System.out.println("father find");
        son.find();
        System.out.println("father find end");
    }

    public static void main(String[] args) {
        Father father = new Father(new Son());
    }
}